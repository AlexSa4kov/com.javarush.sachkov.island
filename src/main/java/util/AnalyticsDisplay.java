package main.java.util;

import main.java.model.Island;

public class AnalyticsDisplay {

    private int countOfOrganism;
    private int countOfAnimals;
    private int countOfPredators;
    private int countOfHerbivores;
    private int countOfPlants;

    //проверяем состояние острова в цикле проходим по Локациям
    private static void checkVariables(Island island) {
    }

    //выводим в консоль информацию по острову
    public void printInformationOfIsland(Island island) {

        System.out.println("Состояние острова:");
        checkVariables(island);

    }
}
