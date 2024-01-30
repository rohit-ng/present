package dev.infraspec.OpenClosed.With;

public class CarPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice() {
        // Pricing logic for a car
        return 20000;
    }
}