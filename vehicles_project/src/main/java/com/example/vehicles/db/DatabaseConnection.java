package com.example.vehicles.db;

import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:vehicles.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initializeDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS vehicles ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "type TEXT NOT NULL,"
                + "brand TEXT NOT NULL,"
                + "model TEXT NOT NULL,"
                + "year INTEGER NOT NULL,"
                + "number_of_doors INTEGER,"
                + "engine_capacity REAL"
                + ");";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Erro ao inicializar DB: " + e.getMessage());
        }
    }
}
