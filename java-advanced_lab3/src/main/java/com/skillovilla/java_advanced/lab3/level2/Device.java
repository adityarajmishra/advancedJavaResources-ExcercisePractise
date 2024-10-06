package com.skillovilla.java_advanced.lab3.level2;

public class Device {
    private String deviceName;
    private String manufacturer;
    private double price;

    public Device(){
        deviceName = "Unknown";
        manufacturer = "Unknown";
        price = 0.0;
    }

    public Device(String deviceName, String manufacturer, double price) {
        this.deviceName = deviceName;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
