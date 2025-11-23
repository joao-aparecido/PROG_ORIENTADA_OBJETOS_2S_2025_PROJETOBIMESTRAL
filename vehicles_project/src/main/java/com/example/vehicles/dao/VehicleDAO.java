package com.example.vehicles.dao;

import com.example.vehicles.db.DatabaseConnection;
import com.example.vehicles.model.*;

import java.sql.*;
import java.util.*;

public class VehicleDAO {

    public void insert(Vehicle v) {
        String sql = "INSERT INTO vehicles(type,brand,model,year,number_of_doors,engine_capacity) VALUES(?,?,?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, v.getType());
            ps.setString(2, v.getBrand());
            ps.setString(3, v.getModel());
            ps.setInt(4, v.getYear());

            if (v instanceof Car) {
                ps.setInt(5, ((Car) v).getNumberOfDoors());
                ps.setNull(6, Types.REAL);
            } else if (v instanceof Motorcycle) {
                ps.setNull(5, Types.INTEGER);
                ps.setDouble(6, ((Motorcycle) v).getEngineCapacity());
            }

            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) v.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir veículo: " + e.getMessage());
        }
    }

    public List<Vehicle> findAll() {
        String sql = "SELECT * FROM vehicles";
        List<Vehicle> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String type = rs.getString("type");
                Vehicle v = null;
                if ("Car".equalsIgnoreCase(type)) {
                    v = new Car(rs.getInt("id"), rs.getString("brand"), rs.getString("model"), rs.getInt("year"), rs.getInt("number_of_doors"));
                } else if ("Motorcycle".equalsIgnoreCase(type)) {
                    v = new Motorcycle(rs.getInt("id"), rs.getString("brand"), rs.getString("model"), rs.getInt("year"), rs.getDouble("engine_capacity"));
                }
                if (v != null) list.add(v);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar veículos: " + e.getMessage());
        }
        return list;
    }

    public Vehicle findById(int id) {
        String sql = "SELECT * FROM vehicles WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String type = rs.getString("type");
                    if ("Car".equalsIgnoreCase(type)) {
                        return new Car(rs.getInt("id"), rs.getString("brand"), rs.getString("model"), rs.getInt("year"), rs.getInt("number_of_doors"));
                    } else if ("Motorcycle".equalsIgnoreCase(type)) {
                        return new Motorcycle(rs.getInt("id"), rs.getString("brand"), rs.getString("model"), rs.getInt("year"), rs.getDouble("engine_capacity"));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar veículo: " + e.getMessage());
        }
        return null;
    }
}
