package com.example.vehicles.service;

import com.example.vehicles.dao.VehicleDAO;
import com.example.vehicles.model.Vehicle;
import java.util.List;

public class VehicleService {
    private final VehicleDAO dao = new VehicleDAO();

    public void addVehicle(Vehicle v) { dao.insert(v); }
    public List<Vehicle> listAll() { return dao.findAll(); }
    public Vehicle getById(int id) { return dao.findById(id); }
}
