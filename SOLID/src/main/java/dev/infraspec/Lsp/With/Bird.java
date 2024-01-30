package dev.infraspec.Lsp.With;

public class Bird {
    public void eat() {
        System.out.println("I can eat.");
    }
}

class FlyingBird extends Bird {
    public void fly() {
        System.out.println("I can fly.");
    }
}

class Swan extends FlyingBird {
    @Override
    public void eat() {
        System.out.println("OMG! I can eat pizza!");
    }

    @Override
    public void fly() {
        System.out.println("I believe I can fly!");
    }
}

class Penguin extends Bird {
    @Override
    public void eat() {
        System.out.println("Can I eat taco?");
    }
}