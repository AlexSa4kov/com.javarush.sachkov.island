package main.java.IO;


import main.java.util.IslandStats;


public class IslandPrinter {

    public void printInformation(IslandStats stats) {
        System.out.println("========== СОСТОЯНИЕ ОСТРОВА ==========");
        System.out.printf("Всего организмов -> %d%n", stats.getTotalCount());
        System.out.printf("Растения         -> %d%n", stats.getPlantCount());
        System.out.printf("Всего животных   -> %d%n", stats.getAnimalCount());
        System.out.println("---------------------------------------");
        System.out.printf("  Хищники        -> %d%n", stats.getPredatorCount());
        System.out.printf("  Травоядные     -> %d%n", stats.getHerbivoreCount());
        System.out.println("=======================================\n");
    }
}
