package org.example.springcourse.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Car {
    private int id;

    @Size(min = 2, max = 50, message = "Name should be between 2 and 30 characters")
    private String brand;

    @Size(min = 2, max = 50, message = "Name should be between 2 and 30 characters")
    private String model;

    @Min(value = 1910, message = "Created date should be greater than 0")
    private int createdDate;

    @Min(value = 0, message = "engine volume should be greater than 0")
    private double engineVolume;

    public Car() {

    }

    public Car(int id, String brand, String model, int createdDate, double engineVolume) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.createdDate = createdDate;
        this.engineVolume = engineVolume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(int createdDate) {
        this.createdDate = createdDate;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }
}
