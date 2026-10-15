package main.java.model.organism;


import main.java.model.organism.abstraction.Organism;

public class Caterpillar extends Organism {
    public Caterpillar() {
        super(
                "Caterpillar",
                "\uD83D\uDC1B",
                100,
                0.01,
                1000,
                true,
                null
        );
    }

    @Override
    public String  toString() {
        return "Caterpillar{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
