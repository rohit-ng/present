package dev.infraspec.OpenClosed.Without;

public class Vehicle {
    private final String type;

    public Vehicle(String type) {
        this.type = type;
    }

    public double calculatePrice() {
        if (type.equalsIgnoreCase("Car")) {
            // Pricing logic for a car
            return 20000;
        } else if (type.equalsIgnoreCase("Truck")) {
            // Pricing logic for a truck
            return 50000;
        }

        return 0;
    }
}
