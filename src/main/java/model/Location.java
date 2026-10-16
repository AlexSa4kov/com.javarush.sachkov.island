package main.java.model;

import main.java.model.organism.abstraction.Animal;
import main.java.model.organism.Plant;

import java.util.ArrayList;

public class Location {
    public ArrayList<Animal> animals;
    public ArrayList<Plant> plants;

    public Location(ArrayList<Animal> animals, ArrayList<Plant> plants) {
        this.animals = animals;
        this.plants = plants;
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
        plant.setLocation(this);
        if (plants.size() < plant.getLimitInArea()) {
            plants.add(plant);
        }
    }

    public Plant getPlantToEat() {
        return plants.isEmpty() ? null : plants.get(0);
    }

    public void removePlant(Plant plant) {
        plants.remove(plant);
    }
}
