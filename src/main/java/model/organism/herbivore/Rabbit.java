package main.java.model.organism.herbivore;

import main.java.model.organism.abstraction.Animal;
import main.java.model.organism.abstraction.Herbivore;

public class Rabbit extends Herbivore {

    public Rabbit() {
        super(
                "Rabbit",
                "\uD83D\uDC07",
                100,
                2,
                150,
                true,
                null,
                2,
                100,
                0.45
        );
    }

    @Override
    public String toString() {
        return "Rabbit{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    @Override
    protected Animal createBaby() {
        return new Rabbit();
    }
}
