package main.java.model.organism.abstraction;

import main.java.constant.AppConstants;
import main.java.model.Island;
import main.java.model.Location;
import main.java.model.organism.Plant;
import main.java.util.IslandUtils;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Organism {

    protected int moveInTik;
    protected double currentSatiety;
    protected double satietyLimitPerEating;
    protected boolean isParticipation = false;


    public Animal(
            String name,
            String icon,
            int health,
            double weight,
            int limitInArea,
            boolean isAlive,
            Location location,
            int moveInTik,
            double currentSatiety,
            double satietyLimitPerEating
    ) {
        super(
                name,
                icon,
                health,
                weight,
                limitInArea,
                isAlive,
                location
        );
        this.moveInTik = moveInTik;
        this.currentSatiety = currentSatiety;
        this.satietyLimitPerEating = satietyLimitPerEating;
    }

    public boolean isParticipation() {
        return isParticipation;
    }

    public void setParticipation(boolean participation) {
        isParticipation = participation;
    }

    protected abstract Animal createBaby();

    public void move() {
        if (!isAlive || location == null || moveInTik == 0 || !isParticipation) {
            return;
        }

        int currentX = location.getX();
        int currentY = location.getY();

        int steps = ThreadLocalRandom.current().nextInt(moveInTik + 1);
        if (steps == 0) {
            this.setParticipation(true);
            return;
        }

        for (int i = 0; i < steps; i++) {
            int direction = ThreadLocalRandom.current().nextInt(4);
            switch (direction) {
                case 0 -> {
                    if (currentX > 0) currentX--;
                }
                case 1 -> {
                    if (currentX < AppConstants.ISLAND_HEIGHT - 1) currentX++;
                }
                case 2 -> {
                    if (currentY > 0) currentY--;
                }
                case 3 -> {
                    if (currentY < AppConstants.ISLAND_WIDTH - 1) currentY++;
                }
            }
        }

        Location targetLocation = Island.location[currentX][currentY];

        if (IslandUtils.hasCapacityForAnimal(targetLocation, this)) {
            Location oldLocation = this.location;
            if (oldLocation != null && IslandUtils.hasCapacityForAnimal(targetLocation, this)) {

                Location firstLock = oldLocation.hashCode() < targetLocation.hashCode() ? oldLocation : targetLocation;
                Location secondLock = firstLock == oldLocation ? targetLocation : oldLocation;

                synchronized (firstLock) {
                    synchronized (secondLock) {
                        if (this.location == oldLocation && IslandUtils.hasCapacityForAnimal(targetLocation, this)) {
                            oldLocation.removeAnimal(this);
                            targetLocation.addAnimal(this);
                        }
                    }
                }
            }

        }
    }

    public void eat() {
        if (!isAlive || location == null) return;

        if (this instanceof Herbivore) {
            Plant plant = location.getPlantToEat();
            if (plant != null && IslandUtils.canEat(this, plant)) {
                if (IslandUtils.isEat(this, plant)) {
                    location.removePlant(plant);
                    this.currentSatiety += currentSatiety * 0.2;
                    return;
                }
            }
        }

        if (this instanceof Predator) {
            ArrayList<Animal> animalsCopy = location.getAnimalsCopy();
            animalsCopy.remove(this);
            for (Animal target : animalsCopy) {
                if (target != this && target.isAlive() && IslandUtils.canEat(this, target)) {
                    if (IslandUtils.isEat(this, target)) {
                        target.die();
                        this.currentSatiety += currentSatiety * 0.2;
                        break;
                    }
                }
            }
        }
    }

    public void multiply() {

        if (!isAlive || location == null) return;

        if (IslandUtils.hasCapacityForAnimal(location, this)) {
            int countOfPopulation = location.getCountOfCurrentAnimal(this.getClass().getSimpleName());
            Animal baby = null;
            if (countOfPopulation >= 2) {
                baby = this.createBaby();
            }

            if (baby != null) {
                location.addAnimal(baby);
                baby.setLocation(location);
            }
        }
    }
}
