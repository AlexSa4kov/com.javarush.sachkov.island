package main.java.model.organisms;


import main.java.model.Location;

public abstract class Animal extends Organism {

    protected int moveInTik;
    protected double currentSatiety;
    protected double satietyLimitPerEating;

    public Animal(String name, String icon, int health, double weight, int limitInArea, boolean isAlive, Location location, int moveInTik, double currentSatiety, double satietyLimitPerEating) {
        super(name, icon, health, weight, limitInArea, isAlive, location);
        this.moveInTik = moveInTik;
        this.currentSatiety = currentSatiety;
        this.satietyLimitPerEating = satietyLimitPerEating;
    }


    public void eat() {}

    public void move() {}


}
