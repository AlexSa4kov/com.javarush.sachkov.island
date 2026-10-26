package main.java.model.organism.herbivore;

import main.java.model.organism.abstraction.Animal;
import main.java.model.organism.abstraction.Herbivore;

public class Boar extends Herbivore {

    public Boar() {
        super(
                "Boar",
                "\uD83D\uDC17",
                100,
                400,
                50,
                true,
                null,
                2,
                100,
                50);
    }

    @Override
    public String toString() {
        return "Boar{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    @Override
    protected Animal createBaby() {
        return new Boar();
    }
}
