package main.java.util;

import main.java.model.Island;
import main.java.model.Location;
import main.java.model.organism.abstraction.Animal;
import main.java.model.organism.herbivore.*;
import main.java.model.organism.predator.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IslandInformation {
    public static void printDayStatistics(int day) {
        ArrayList<Location> locations = Island.getInstance().getLocationOfIsland();
        Map<String, Integer> globalAnimalCounts = new HashMap<>();
        int totalPlants = 0;

        for (Location loc : locations) {
            totalPlants += loc.getCountOfPlant();
            for (Animal animal : loc.getAnimalsCopy()) {
                if (animal.isAlive()) {
                    String icon = animal.getIcon();
                    globalAnimalCounts.put(icon, globalAnimalCounts.getOrDefault(icon, 0) + 1);
                }
            }
        }

        System.out.println("---- СТАТИСТИКА ДНЯ " + day + " ----");
        System.out.println("🌱 - " + totalPlants);

        if (globalAnimalCounts.isEmpty()) {
            System.out.println("💀 На острове не осталось живых животных...");
        } else {
            for (Map.Entry<String, Integer> entry : globalAnimalCounts.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
        System.out.println("=========================================");
    }
}
