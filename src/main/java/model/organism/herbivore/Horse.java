package main.java.model.organism.herbivore;

import main.java.model.organism.abstraction.Herbivore;

public class Horse extends Herbivore {

    public Horse() {
        super(
                "Horse",
                "\uD83D\uDC0E",
                100,
                400,
                20,
                true,
                null,
                4,
                100,
                60
        );
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
