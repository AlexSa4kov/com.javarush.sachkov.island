package main.java.model.organism.predators;

import main.java.model.organism.predators.abstraction.Predator;

public class Wolf extends Predator {

    public Wolf() {
        super(
                "Волк",
                "\uD83D\uDC3A",
                100, 50.0,
                30,
                true,
                null,
                3,
                100,
                8
        );
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
