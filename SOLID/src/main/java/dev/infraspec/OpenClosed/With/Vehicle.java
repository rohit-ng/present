package dev.infraspec.OpenClosed.With;

public class Vehicle {
    private final PricingStrategy pricingStrategy;

    public Vehicle(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculatePrice() {
        return pricingStrategy.calculatePrice();
    }
}