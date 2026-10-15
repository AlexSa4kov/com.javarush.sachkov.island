package main.java.model.organism.abstraction;

import main.java.model.Location;
import main.java.util.IslandUtils;

import java.util.concurrent.ThreadLocalRandom;

//Прародитель всего и вся
public abstract class Organism {

    protected String name;
    protected String icon;
    protected int health;
    protected double weight;
    protected int limitInArea;
    protected boolean isAlive;
    protected Location location;


    public Organism(
            String name,
            String icon,
            int health,
            double weight,
            int limitInArea,
            boolean isAlive,
            Location location
    ) {
        this.name = name;
        this.icon = icon;
        this.health = health;
        this.weight = weight;
        this.limitInArea = limitInArea;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getLimitInArea() {
        return limitInArea;
    }

    public void setLimitInArea(int limitInArea) {
        this.limitInArea = limitInArea;
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



    public void die() {
        this.isAlive = false;
    }
}
