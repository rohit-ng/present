package dev.infraspec.InterfaceSegregation.Without;

public interface Worker {
    void work();

    void eat();

    void sleep();
}

class Robot implements Worker {
    public void work() {
        System.out.println("Robot is working.");
    }

    public void eat() {
        // Robots don't eat
        throw new UnsupportedOperationException("Robots don't need to eat.");
    }

    public void sleep() {
        // Robots don't sleep
        throw new UnsupportedOperationException("Robots don't need to sleep.");
    }
}

