package main.java.model.organism.predator;

import main.java.model.organism.abstraction.Predator;

public class Eagle extends Predator {
    public Eagle() {
        super(
                "Eagle",
                "\uD83E\uDD85",
                100,
                6.0,
                20,
                true,
                null,
                3,
                100,
                1.0
        );
    }

    @Override
    public String toString() {
        return "Eagle{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
