package main.java.model.organism.predator;

import main.java.model.organism.abstraction.Predator;

public class Wolf extends Predator {

    public Wolf() {
        super(
                "Wolf",
                "\uD83D\uDC3A",
                100,
                50.0,
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
