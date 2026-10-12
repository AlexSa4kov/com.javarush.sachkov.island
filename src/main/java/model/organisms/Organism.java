package main.java.model.organisms;

import main.java.model.Location;


public abstract class Organism {

    protected String name;
    protected String icon;
    protected int health;
    protected int weight;
    protected int limitInArea;
    protected int speed;
    protected double currentSatiety;
    protected double satietyLimitPerEating;
    protected boolean isAlive;
    protected Location location;


    public Organism(String name, String icon,
                    int health, int weight, int limitInArea,
                    int speed, double currentSatiety,
                    double satietyLimitPerEating, boolean isAlive,
                    Location location) {
        this.name = name;
        this.icon = icon;
        this.health = health;
        this.weight = weight;
        this.limitInArea = limitInArea;
        this.speed = speed;
        this.currentSatiety = currentSatiety;
        this.satietyLimitPerEating = satietyLimitPerEating;
        this.isAlive = isAlive;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public int getLimitInArea() {
        return limitInArea;
    }

    public void setLimitInArea(int limitInArea) {
        this.limitInArea = limitInArea;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
