package main.java.model.organism.herbivore;

import main.java.model.organism.abstraction.Herbivore;

public class Goat extends Herbivore {
    public Goat() {
        super(
                "Goat",
                "\uD83D\uDC10",
                100,
                60,
                140,
                true,
                null,
                3,
                100,
                10
        );
    }

    @Override
    public String toString() {
        return "Goat{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
