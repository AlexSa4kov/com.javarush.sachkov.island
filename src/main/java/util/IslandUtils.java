package main.java.util;

import main.java.model.Location;
import main.java.model.organism.abstraction.Animal;

public class IslandUtils {

    public static boolean hasCapacityForAnimal(Location location, Animal animal) {
        int count = location.countOfCurrentAnimal(animal.getClass().getSimpleName());
        return count >= animal.getLimitInArea();
    }
}
