package main.java.model.organism.predator;

import main.java.model.organism.abstraction.Predator;

public class Bear extends Predator {

    public Bear() {
        super(
                "Bear",
                "\uD83D\uDC3B",
                100,
                500,
                5,
                true,
                null,
                2,
                100,
                80
        );
    }

    @Override
    public String toString() {
        return "Bear{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
