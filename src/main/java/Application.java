package main.java;


import main.java.model.Island;
import main.java.model.Location;
import main.java.model.organisms.Animal;
import main.java.model.organisms.Plant;
import main.java.model.organisms.predators.Wolf;


import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {


        Island INSTANCE = Island.getInstance();
        Location[][] location = Island.location;
        //создали локацию со списками животных и растений
        ArrayList<Animal> animals = new  ArrayList<>();
        animals.add(new Wolf());
        animals.add(new Wolf());
        animals.add(new Wolf());
        ArrayList<Plant> plants = new  ArrayList<>();
        plants.add(new Plant());
        plants.add(new Plant());
        plants.add(new Plant());


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

    }
}