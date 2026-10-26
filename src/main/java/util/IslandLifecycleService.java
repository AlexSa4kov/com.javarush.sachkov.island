package main.java.util;

import main.java.model.Island;
import main.java.model.Location;
import main.java.model.organism.abstraction.Animal;
import java.util.ArrayList;
import java.util.List;

public class IslandLifecycleService {
    private final Island island;

    public IslandLifecycleService() {
        this.island = Island.getInstance();
    }

    public List<Animal> prepareAndCollectAliveAnimals() {
        List<Animal> allAnimals = new ArrayList<>();

        for (Location location : island.getLocationOfIsland()) {
            for (Animal animal : location.getAnimalsCopy()) {
                if (animal.isAlive()) {
                    animal.setHasEatInThisDay(false);
                    animal.setHasMultiplyInThisDay(false);
                    animal.setHasMovedInThisDay(false);

                    allAnimals.add(animal);
                }
            }
        }
        return allAnimals;
    }
}
