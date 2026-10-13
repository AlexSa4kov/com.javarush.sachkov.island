package main.java.util;

import main.java.model.Island;
import main.java.model.Location;
import main.java.model.organism.Animal;
import main.java.model.organism.Plant;
import main.java.model.organism.herbivore.abstraction.Herbivore;
import main.java.model.organism.predator.abstraction.Predator;

import java.util.ArrayList;

public class StatisticsCollector {

    public IslandStats collectData(Island island) {
        long countOfPlants = 0;
        long countOfPredators = 0;
        long countOfHerbivores = 0;

        // Предположим, у острова есть доступ к его локациям
        Location[][] location = Island.location;

        for (int i = 0; i < location.length; i++) {
            for (int j = 0; j < location[i].length; j++) {
                ArrayList<Plant> plants = location[i][j].plants;

                for (Plant plant : plants) {
                    if(plant.isAlive()) {
                        countOfPlants++;
                    }
                }
                ArrayList<Animal> animals = location[i][j].animals;
                for (Animal animal : animals) {
                    if(animal.isAlive()) {
                        if (animal instanceof Predator) {
                            countOfPredators++;
                        }
                        if (animal instanceof Herbivore) {
                            countOfHerbivores++;
                        }
                    }
                }
            }
        }

        return new IslandStats(countOfPlants, countOfPredators, countOfHerbivores);
    }
}
