package main.java.model.organism;

import main.java.model.organism.abstraction.Organism;

public class Plant extends Organism {
    public Plant() {

        super(
                "Растение",
                "\uD83C\uDF31",
                100,
                1,
                200,
                true,
                null
        );
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    @Override
    public void multiply() {
        System.out.println("Метод размножения у РАСТЕНИЙ");;
    }
}
