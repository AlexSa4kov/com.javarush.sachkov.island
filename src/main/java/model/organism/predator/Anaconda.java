package main.java.model.organism.predator;

import main.java.model.organism.abstraction.Predator;

public class Anaconda extends Predator {

    public Anaconda() {
        super(
                "Anaconda",
                "\uD83D\uDC0D",
                100,
                15,
                30,
                true,
                null,
                1,
                100,
                3
        );
    }

    @Override
    public String toString() {
        return "Anaconda{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
