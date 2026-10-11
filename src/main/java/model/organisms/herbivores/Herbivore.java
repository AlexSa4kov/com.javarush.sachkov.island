package main.java.model.organisms.herbivores;

import main.java.model.organisms.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(String name, int health, int weight, int limitOfAnimalsInArea, int limitOfMoved, double currentSatiety, double satietyLimit) {
        super(name, health, weight, limitOfAnimalsInArea, limitOfMoved, currentSatiety, satietyLimit);
    }
}
