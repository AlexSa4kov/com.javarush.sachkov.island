package main.java.model.organism;

import main.java.model.organism.abstraction.Animal;

public class Caterpillar extends Animal {

    public Caterpillar() {
        super(
                "Caterpillar",
                "\uD83D\uDC1B",
                100,
                0.01,
                1000,
                true,
                null,
                0,
                0,
                0
        );
    }

    @Override
    public String  toString() {
        return "Caterpillar{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    @Override
    protected Animal createBaby() {
        return new Caterpillar();
    }
}
