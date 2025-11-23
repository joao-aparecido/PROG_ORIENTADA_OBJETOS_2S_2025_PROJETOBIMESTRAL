package com.example.vehicles.model;

public abstract class Vehicle {
    private Integer id;
    private String brand;
    private String model;
    private int year;

    public Vehicle() {}

    public Vehicle(Integer id, String brand, String model, int year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public abstract String getType();

    @Override
    public String toString() {
        return "[" + getType() + "] id=" + id + ", " + brand + " " + model + " (" + year + ")";
    }
}
