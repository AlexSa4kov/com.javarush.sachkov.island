package main.java.util;

import main.java.constant.AppConstants;
import main.java.model.Location;
import main.java.model.organism.Caterpillar;
import main.java.model.organism.Plant;
import main.java.model.organism.abstraction.Animal;
import main.java.model.organism.abstraction.Organism;
import main.java.model.organism.herbivore.*;
import main.java.model.organism.predator.*;

import java.util.concurrent.ThreadLocalRandom;

public class IslandUtils {

    public static boolean hasCapacityForAnimal(Location location, Animal animal) {
        int count = location.getCountOfCurrentAnimal(animal.getClass().getSimpleName());
        return count < animal.getLimitInArea();
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

    //рандомная инициализация каждого подвида
    public static void populationOfLocation(Location location) {

        int plantsCount = ThreadLocalRandom.current().nextInt(20, 150);
        for (int i = 0; i < plantsCount; i++) {
            location.addPlant(new Plant());
        }
        int wolves = ThreadLocalRandom.current().nextInt(1, 15);
        for (int i = 0; i < wolves; i++) {
            location.addAnimal(new Wolf());
        }
        int anaconds = ThreadLocalRandom.current().nextInt(0, 10);
        for (int i = 0; i < anaconds; i++) {
            location.addAnimal(new Anaconda());
        }
        int foxes = ThreadLocalRandom.current().nextInt(1, 15);
        for (int i = 0; i < foxes; i++) {
            location.addAnimal(new Fox());
        }
        int bears = ThreadLocalRandom.current().nextInt(0, 5);
        for (int i = 0; i < bears; i++) {
            location.addAnimal(new Bear());
        }
        int eagles = ThreadLocalRandom.current().nextInt(0, 10);
        for (int i = 0; i < eagles; i++) {
            location.addAnimal(new Eagle());
        }
        int horses = ThreadLocalRandom.current().nextInt(0, 10);
        for (int i = 0; i < horses; i++) {
            location.addAnimal(new Horse());
        }
        int deer = ThreadLocalRandom.current().nextInt(0, 10);
        for (int i = 0; i < deer; i++) {
            location.addAnimal(new Deer());
        }
        int rabbits = ThreadLocalRandom.current().nextInt(2, 150);
        for (int i = 0; i < rabbits; i++) {
            location.addAnimal(new Rabbit());
        }
        int mice = ThreadLocalRandom.current().nextInt(2, 250);
        for (int i = 0; i < mice; i++) {
            location.addAnimal(new Mouse());
        }
        int goats = ThreadLocalRandom.current().nextInt(0, 70);
        for (int i = 0; i < goats; i++) {
            location.addAnimal(new Goat());
        }
        int sheep = ThreadLocalRandom.current().nextInt(0, 70);
        for (int i = 0; i < sheep; i++) {
            location.addAnimal(new Sheep());
        }
        int boars = ThreadLocalRandom.current().nextInt(0, 25);
        for (int i = 0; i < boars; i++) {
            location.addAnimal(new Boar());
        }
        int buffaloes = ThreadLocalRandom.current().nextInt(0, 10);
        for (int i = 0; i < buffaloes; i++) {
            location.addAnimal(new Buffalo());
        }
        int ducks = ThreadLocalRandom.current().nextInt(1, 100);
        for (int i = 0; i < ducks; i++) {
            location.addAnimal(new Duck());
        }
        int caterpillars = ThreadLocalRandom.current().nextInt(100, 500);
        for (int i = 0; i < caterpillars; i++) {
            location.addAnimal(new Caterpillar());
        }
    }
}
