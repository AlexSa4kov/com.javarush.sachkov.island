package main.java.model;

import main.java.model.organism.Animal;
import main.java.model.organism.Plant;

import java.util.ArrayList;

public class Location {
    public ArrayList<Animal> animals;
    public ArrayList<Plant> plants;

    public Location(ArrayList<Animal> animals, ArrayList<Plant> plants) {
        this.animals = animals;
        this.plants = plants;
    }
}
