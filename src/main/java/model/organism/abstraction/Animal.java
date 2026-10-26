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
    protected boolean hasMovedInThisDay = false;
    protected boolean hasMultiplyInThisDay = false;
    protected boolean hasEatInThisDay = false;

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

    public double getCurrentSatiety() {
        return currentSatiety;
    }

    public void setCurrentSatiety(double currentSatiety) {
        this.currentSatiety = currentSatiety;
    }

    public boolean isHasMovedInThisDay() {
        return hasMovedInThisDay;
    }

    public void setHasMovedInThisDay(boolean hasMovedInThisDay) {
        this.hasMovedInThisDay = hasMovedInThisDay;
    }

    public boolean isHasMultiplyInThisDay() {
        return hasMultiplyInThisDay;
    }

    public void setHasMultiplyInThisDay(boolean hasMultiplyInThisDay) {
        this.hasMultiplyInThisDay = hasMultiplyInThisDay;
    }

    public boolean isHasEatInThisDay() {
        return hasEatInThisDay;
    }

    public void setHasEatInThisDay(boolean hasEatInThisDay) {
        this.hasEatInThisDay = hasEatInThisDay;
    }

    protected abstract Animal createBaby();

    public void move() {
        if (!isAlive || location == null || moveInTik == 0 || !hasMovedInThisDay) {
            return;
        }

        int currentX = location.getX();
        int currentY = location.getY();

        int steps = ThreadLocalRandom.current().nextInt(moveInTik + 1);
        if (steps == 0) {
            this.setHasMovedInThisDay(true);
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
                            this.setHasMovedInThisDay(true);
                            oldLocation.removeAnimal(this);
                            targetLocation.addAnimal(this);
                        }
                    }
                }
            }

        }
    }

    public void eat() {
        if (!isAlive || location == null || hasEatInThisDay) {
            return;
        }

        if (this instanceof Herbivore) {
            synchronized (location) {
                Plant plant = location.getPlantToEat();
                if (plant != null && plant.isAlive() && IslandUtils.canEat(this, plant)) {
                    if (IslandUtils.isEat(this, plant)) {
                        plant.die();
                        location.removePlant(plant);
                        this.setCurrentSatiety(Math.min(this.satietyLimitPerEating, this.getCurrentSatiety() + plant.getWeight()));
                        this.hasEatInThisDay = true;
                        return;
                    }
                }
            }
        }

        if (this instanceof Predator) {
            ArrayList<Animal> animalsCopy = location.getAnimalsCopy();

            for (Animal target : animalsCopy) {
                if (target != this && target.isAlive() && IslandUtils.canEat(this, target)) {
                    synchronized (location) {
                        if (target.isAlive() && this.isAlive() && !this.hasEatInThisDay) {

                            if (IslandUtils.isEat(this, target)) {
                                target.die();
                                location.removeAnimal(target);

                                this.setCurrentSatiety(Math.min(this.satietyLimitPerEating, this.getCurrentSatiety() + target.getWeight()));
                                this.hasEatInThisDay = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void multiply() {

        if (!isAlive || location == null || hasMultiplyInThisDay) {
            return;
        }

        synchronized (location) {
            if (hasMultiplyInThisDay || !IslandUtils.hasCapacityForAnimal(location, this)) {
                return;
            }

            Animal partner = null;
            for (Animal potentialPartner : location.getAnimalsCopy()) {
                if (potentialPartner != this
                        && potentialPartner.isAlive()
                        && potentialPartner.getClass().getSimpleName().equals(this.getClass().getSimpleName())
                        && !potentialPartner.isHasMultiplyInThisDay()) {

                    partner = potentialPartner;
                    break;
                }
            }

            if (partner != null) {
                Animal baby = this.createBaby();
                if (baby != null) {
                    location.addAnimal(baby);
                    baby.setLocation(location);
                    baby.setHasMovedInThisDay(true);
                    baby.setHasMultiplyInThisDay(true);
                    this.setHasMultiplyInThisDay(true);
                    partner.setHasMultiplyInThisDay(true);
                }
            }
        }
    }
}
