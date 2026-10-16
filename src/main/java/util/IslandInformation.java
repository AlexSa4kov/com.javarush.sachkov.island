package main.java.util;

import main.java.model.Island;
import main.java.model.Location;
import main.java.model.organism.abstraction.Animal;
import main.java.model.organism.herbivore.*;
import main.java.model.organism.predator.*;

import java.util.HashMap;
import java.util.Map;

public class IslandInformation {
    public static void printDayStatistics(int day) {
        Location[][] locations = Island.location;
        Map<String, Integer> animalsCountByType = new HashMap<>();
        int totalPlants = 0;

        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                Location loc = locations[x][y];
                totalPlants += loc.plants.size();

                if (loc.animals != null) {
                    for (Animal animal : loc.animals) {
                            String typeName = animal.getClass().getSimpleName();
                            int currentCount = animalsCountByType.getOrDefault(typeName, 0);
                            animalsCountByType.put(typeName, currentCount + 1);
                    }
                }
            }
        }

        System.out.println("Еще один день на острове");
        System.out.printf("Номер -> %d", day);
        System.out.println();
        System.out.println("Всего растений: " + totalPlants);
        for (Map.Entry<String, Integer> entry : animalsCountByType.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("---------------------------------------------------");
    }
}
