package org.example.hometask1.task5;

public class Car implements Drivable{
    private String brand;
    private String model;
    private int year;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    @Override
    public void start() {
        System.out.println("The car is starting....");
    }

    @Override
    public void stop() {
        System.out.println("The car is stopping....");
    }

    @Override
    public void drive(int distance) {
        System.out.println("The car passed: " + distance + "km");
    }
}
