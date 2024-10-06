package com.skillovilla.java_advanced.lab4.level2;

import java.io.Serializable;

public class Device implements Serializable {
    String modelName;
    String manufacturer;
    double cost;

    public Device() {
    }

    public Device(String modelName, String manufacturer, double cost) {
        this.modelName = modelName;
        this.manufacturer = manufacturer;
        this.cost = cost;
    }

    public String getModelName() {
        return modelName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getCost() {
        return cost;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
