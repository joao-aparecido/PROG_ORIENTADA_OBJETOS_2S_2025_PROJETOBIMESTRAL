package com.example.vehicles.model;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car() { super(); }

    public Car(Integer id, String brand, String model, int year, int numberOfDoors) {
        super(id, brand, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() { return numberOfDoors; }
    public void setNumberOfDoors(int numberOfDoors) { this.numberOfDoors = numberOfDoors; }

    @Override
    public String getType() { return "Car"; }

    @Override
    public String toString() {
        return super.toString() + ", doors=" + numberOfDoors;
    }
}
