package main.java.model;

import main.java.model.organism.abstraction.Animal;
import main.java.model.organism.Plant;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Location {
    private final int x;
    private final int y;
    public CopyOnWriteArrayList<Animal> animals;
    public CopyOnWriteArrayList<Plant> plants;



    public Location(int x, int y, CopyOnWriteArrayList<Animal> animals, CopyOnWriteArrayList<Plant> plants) {
        this.x = x;
        this.y = y;
        this.animals = animals;
        this.plants = plants;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addAnimal(Animal animal) {
        animal.setLocation(this);
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
        if(animal.getLocation() == this) {
            animal.setLocation(null);
        }
    }

    public ArrayList<Animal> getAnimalsCopy() {
        return new ArrayList<>(animals);
    }
    public ArrayList<Plant> getPlantsCopy() {
        return new ArrayList<>(plants);
    }

    public int getCountOfCurrentAnimal(String currentAnimal) {
        int count = 0;
        for (Animal a : animals) {
            if (a.isAlive() && a.getClass().getSimpleName().equals(currentAnimal)) {
                count++;
            }
        }
        return count;
    }

    public int getCountOfPlant() {
        return plants.size();
    }

    public  void addPlant(Plant plant) {
        if (plant == null) {
            return;
        }

        if (this.plants.size() < plant.getLimitInArea()) {
            plant.setLocation(this);
            this.plants.add(plant);
        }
    }


    public Plant getPlantToEat() {
        return plants.isEmpty() ? null : plants.get(0);
    }

    public void removePlant(Plant plant) {
        plants.remove(plant);
    }
}
