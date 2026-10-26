package main.java.model.organism.herbivore;

import main.java.model.organism.abstraction.Animal;
import main.java.model.organism.abstraction.Herbivore;

public class Buffalo extends Herbivore {

    public Buffalo() {
        super(
                "Buffalo",
                "\uD83D\uDC03",
                100,
                700,
                10,
                true,
                null,
                3,
                100,
                100
        );
    }

    @Override
    public String toString() {
        return "Buffalo{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    @Override
    protected Animal createBaby() {
        return new Buffalo();
    }
}
