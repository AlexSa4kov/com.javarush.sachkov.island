package main.java;


import main.java.model.organisms.predators.Wolf;

public class Application {
    public static void main(String[] args) {

        //чтобы был остров -> нужны Локации
        //чтобы была локация -> нужен список Животных и список Растений

        Wolf wolf = new Wolf();
        System.out.println(wolf.toString());
        wolf.die();
        wolf.eat();
        wolf.multiply();
        System.out.println(wolf.getName());


    }
}