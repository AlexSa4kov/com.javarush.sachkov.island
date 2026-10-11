package main.java.model;

import main.java.model.organisms.Animal;
import main.java.model.organisms.Plant;

import java.util.ArrayList;

public class Location {
    public ArrayList<Animal> animals;
    public ArrayList<Plant> plants;

    public Location(ArrayList<Animal> animals, ArrayList<Plant> plants) {
        this.animals = animals;
        this.plants = plants;
    }
}
