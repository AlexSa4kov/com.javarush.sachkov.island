package main.java;


import main.java.model.Island;
import main.java.model.Location;
import main.java.model.organism.Plant;
import main.java.model.organism.abstraction.Animal;
import main.java.util.IslandInformation;

import java.util.ArrayList;

//Костыль на одну ячейку......

public class Application {
    public static void main(String[] args) {
        Island island = Island.getInstance();
        island.populateIsland();
        ArrayList<Location> location = island.getLocationOfIsland();
        int day = 0;

        while (true) {
            day++;
            for (Location location1 : location) {
                ArrayList<Animal> animalsCopy = location1.getAnimalsCopy();
                for (Animal animal : animalsCopy) {
                    animal.move();
                    animal.eat();
                    animal.multiply();
                }
                ArrayList<Plant> plantsCopy = location1.getPlantsCopy();
                for (Plant plant : plantsCopy) {
                    plant.plantMultiply();
                }
            }


            IslandInformation.printDayStatistics(day);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

