package com.example.vehicles.model;

public class Motorcycle extends Vehicle {
    private double engineCapacity;

    public Motorcycle() { super(); }

    public Motorcycle(Integer id, String brand, String model, int year, double engineCapacity) {
        super(id, brand, model, year);
        this.engineCapacity = engineCapacity;
    }

    public double getEngineCapacity() { return engineCapacity; }
    public void setEngineCapacity(double engineCapacity) { this.engineCapacity = engineCapacity; }

    @Override
    public String getType() { return "Motorcycle"; }

    @Override
    public String toString() {
        return super.toString() + ", engine=" + engineCapacity + "cc";
    }
}
