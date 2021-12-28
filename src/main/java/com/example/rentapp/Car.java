package com.example.rentapp;

import com.google.gson.annotations.SerializedName;

public class Car {
    @SerializedName("uuid")
    String id;
    String brand;
    String model;
    @SerializedName("license_plate")
    String licensePlate;
    @SerializedName("daily_cost")
    String dailyCost;
    @SerializedName("car_type")
    String carType;
    @SerializedName("rental_service")
    String rentalService;

    public Car(String id, String brand, String model, String licensePlate, String dailyCost, String carType, String rentalService) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.dailyCost = dailyCost;
        this.carType = carType;
        this.rentalService = rentalService;
    }
}
