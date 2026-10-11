package main.java.model.organisms.predators;


import main.java.model.organisms.Animal;

public abstract class Predator extends Animal {
    public Predator(String name, int health, int weight, int limitOfAnimalsInArea, int limitOfMoved, double currentSatiety, double satietyLimit) {
        super(name, health, weight, limitOfAnimalsInArea, limitOfMoved, currentSatiety, satietyLimit);
    }
}
