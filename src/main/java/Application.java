package main.java;


import main.java.io.IslandPrinter;
import main.java.model.Island;
import main.java.model.Location;
import main.java.model.organism.Animal;
import main.java.model.organism.Plant;
import main.java.util.StatisticsCollector;


import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {


        Island INSTANCE = Island.getInstance();
        Location[][] location = Island.location;
        //создали списки животных и растений
        ArrayList<Animal> animals = new  ArrayList<>();
        ArrayList<Plant> plants = new  ArrayList<>();


        //наполняем локации списками, для дальнейшего помещения в них "живности"
        for (int i = 0; i < location.length; i++) {
            for (int j = 0; j < location[i].length; j++) {
                location[i][j] = new Location(animals, plants);

            }
        }


        for (int i = 0; i < location.length; i++) {
            System.out.print("");
            System.out.println("---------------------------------------------");
            for (int j = 0; j < location[i].length; j++) {
                System.out.println(location[i][j].animals.toString());
                System.out.println(location[i][j].plants.toString());
                System.out.print("");
                System.out.println("---------------------------------------------");
                }
        }

        StatisticsCollector collector = new StatisticsCollector();
        IslandPrinter printer = new IslandPrinter();
        printer.printInformation(collector.collectData(INSTANCE));


    }
}