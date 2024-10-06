package com.skillovilla.java_advanced.lab4.level1;

import java.io.Serializable;

public class Gadget implements Serializable {
    String model;
    String brand;
    double price;

    public Gadget() {
    }

    public Gadget(String model, String brand, double price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Gadget [model=" + model + ", brand=" + brand + ", price=" + price + "]";
    }

}
