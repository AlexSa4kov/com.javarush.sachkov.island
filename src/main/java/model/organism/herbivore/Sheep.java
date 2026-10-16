package main.java.model.organism.herbivore;

import main.java.model.organism.abstraction.Herbivore;

public class Sheep extends Herbivore {

    public Sheep() {
        super(
                "Sheep",
                "\uD83D\uDC11",
                100,
                70,
                140,
                true,
                null,
                3,
                100,
                15
        );
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
