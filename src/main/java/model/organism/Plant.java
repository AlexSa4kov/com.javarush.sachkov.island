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

    public void plantMultiply() {
        if (!isAlive || location == null) {
            return;
        }

        if (location.getCountOfPlant() < limitInArea) {
            Plant newPlant = new Plant();
            location.addPlant(newPlant);
            newPlant.setLocation(location);
        }
    }
}
