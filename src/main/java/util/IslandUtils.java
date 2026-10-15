package main.java.util;

import main.java.constant.AppConstants;
import main.java.model.Location;
import main.java.model.organism.abstraction.Animal;
import main.java.model.organism.abstraction.Organism;

import java.util.concurrent.ThreadLocalRandom;

public class IslandUtils {

    public static boolean hasCapacityForAnimal(Location location, Animal animal) {
        int count = location.getCountOfCurrentAnimal(animal.getClass().getSimpleName());
        return count >= animal.getLimitInArea();
    }

    public static int successRateOfEating(String hunter, String prey) {

        Integer rowIndex = AppConstants.ROW_INDEX.get(hunter);
        Integer colIndex = AppConstants.COL_INDEX.get(prey);

        if (rowIndex == null || colIndex == null) {
            throw new IllegalArgumentException("Нет данных в системе.");
        }

        return AppConstants.MATRIX_OF_CHANCE_EATING[rowIndex][colIndex];
    }

    public static boolean canEat(Animal predator, Organism prey) {
        String pred = predator.getClass().getSimpleName();
        String target = prey.getClass().getSimpleName();
        return successRateOfEating(pred, target) > 0;
    }

    public static boolean isEat(Animal predator, Organism prey) {
        String pred = predator.getClass().getSimpleName();
        String target = prey.getClass().getSimpleName();
        int rate = successRateOfEating(pred, target);
        if (rate <= 0) {
            return false;
        }
        return ThreadLocalRandom.current().nextInt(100) < rate;
    }
}
