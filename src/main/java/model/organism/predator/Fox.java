package main.java.model.organism.predator;

import main.java.model.organism.abstraction.Predator;

public class Fox extends Predator {

    public Fox() {
        super(
                "Fox",
                "\uD83E\uDD8A",
                100,
                8,
                30,
                true,
                null,
                2,
                100,
                2
        );
    }

    @Override
    public String toString() {
        return "Fox{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
