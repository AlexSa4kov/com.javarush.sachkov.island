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
        System.out.println("<--------------------------------------------->");
    }

    public static void printStartInformation() {
        System.out.println("Добро пожаловать в симуляцию острова....");
        System.out.println("1. Запуск с дефолтными настройками:\n" +
                "    высота острова = 100;\n" +
                "    ширина острова = 20;\n" +
                "    количество потоков = 8;\n" +
                "    длинна стадии жизненного цикла = 20мс;\n" +
                "    длительность одного дня = 100мс;");

        System.out.println("2. Ручная настройка параметров симуляции" + " -------> пока не доступна, прошу прощения =/");
        System.out.println("Однако при желании, Вы можете побаловаться в настройках в package main.java.constant;");
        System.out.println("Жизнь начнется через 5 секунд....");

    }
}
