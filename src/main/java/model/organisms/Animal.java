package main.java.model.organisms;


public abstract class Animal extends Organism {

    protected String name;
    protected int health;
    protected int weight;
    protected int limitOfAnimalsInArea;
    protected int limitOfMoved;
    protected double currentSatiety;
    protected double satietyLimitPerEating;

    public Animal(String name, int health, int weight, int limitOfAnimalsInArea, int limitOfMoved, double currentSatiety, double satietyLimit) {
        this.name = name;
        this.health = health;
        this.weight = weight;
        this.limitOfAnimalsInArea = limitOfAnimalsInArea;
        this.limitOfMoved = limitOfMoved;
        this.currentSatiety = currentSatiety;
        this.satietyLimitPerEating = satietyLimit;
    }

    public abstract void eat();

    public abstract void move();

    public abstract void multiply();

    public abstract void die();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLimitOfAnimalsInArea() {
        return limitOfAnimalsInArea;
    }

    public void setLimitOfAnimalsInArea(int limitOfAnimalsInArea) {
        this.limitOfAnimalsInArea = limitOfAnimalsInArea;
    }

    public int getLimitOfMoved() {
        return limitOfMoved;
    }

    public void setLimitOfMoved(int limitOfMoved) {
        this.limitOfMoved = limitOfMoved;
    }

    public double getCurrentSatiety() {
        return currentSatiety;
    }

    public void setCurrentSatiety(double currentSatiety) {
        this.currentSatiety = currentSatiety;
    }

    public double getSatietyLimitPerEating() {
        return satietyLimitPerEating;
    }

    public void setSatietyLimitPerEating(double satietyLimitPerEating) {
        this.satietyLimitPerEating = satietyLimitPerEating;
    }
}
