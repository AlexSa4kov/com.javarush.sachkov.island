package main.java.util;

import main.java.constant.AppConstants;
import main.java.model.Island;
import main.java.model.Location;
import main.java.model.organism.Caterpillar;
import main.java.model.organism.Plant;
import main.java.model.organism.abstraction.Animal;
import main.java.model.organism.abstraction.Organism;
import main.java.model.organism.herbivore.*;
import main.java.model.organism.predator.*;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

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

    public static boolean checkIfAllAnimalsDead(Island island) {
        for (Location loc : island.getLocationOfIsland()) {
            for (Animal animal : loc.getAnimalsCopy()) {
                if (animal.isAlive()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void populationOfLocation(Location location) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        int plantsCount = random.nextInt(20, 100);
        for (int i = 0; i < plantsCount; i++) {
            location.addPlant(new Plant());
        }

        for (SpawnRule rule : SPAWN_RULES.values()) {
            int count = random.nextInt(rule.getMin(), rule.getMax() + 1);

            for (int i = 0; i < count; i++) {
                location.addAnimal(rule.getFactory().get());
            }
        }
    }

    private static final Map<String, SpawnRule> SPAWN_RULES = Map.ofEntries(
            Map.entry("Wolf", new IslandUtils.SpawnRule(Wolf::new, 1, 15)),
            Map.entry("Anaconda", new IslandUtils.SpawnRule(Anaconda::new, 0, 10)),
            Map.entry("Fox", new IslandUtils.SpawnRule(Fox::new, 1, 15)),
            Map.entry("Bear", new IslandUtils.SpawnRule(Bear::new, 0, 5)),
            Map.entry("Eagle", new IslandUtils.SpawnRule(Eagle::new, 0, 10)),
            Map.entry("Horse", new IslandUtils.SpawnRule(Horse::new, 0, 10)),
            Map.entry("Deer", new IslandUtils.SpawnRule(Deer::new, 0, 10)),
            Map.entry("Rabbit", new IslandUtils.SpawnRule(Rabbit::new, 2, 150)),
            Map.entry("Mouse", new IslandUtils.SpawnRule(Mouse::new, 2, 250)),
            Map.entry("Goat", new IslandUtils.SpawnRule(Goat::new, 0, 70)),
            Map.entry("Sheep", new IslandUtils.SpawnRule(Sheep::new, 0, 70)),
            Map.entry("Boar", new IslandUtils.SpawnRule(Boar::new, 0, 25)),
            Map.entry("Buffalo", new IslandUtils.SpawnRule(Buffalo::new, 0, 10)),
            Map.entry("Duck", new IslandUtils.SpawnRule(Duck::new, 1, 100)),
            Map.entry("Caterpillar", new IslandUtils.SpawnRule(Caterpillar::new, 100, 150))
    );

    private static class SpawnRule {
        private final Supplier<Animal> factory;
        private final int min;
        private final int max;

        public SpawnRule(Supplier<Animal> factory, int min, int max) {
            this.factory = factory;
            this.min = min;
            this.max = max;
        }

        public Supplier<Animal> getFactory() {
            return factory;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }
    }
}
