package main.java.model.organism.herbivore;

import main.java.model.organism.abstraction.Herbivore;

public class Deer extends Herbivore {
    public Deer() {
        super(
                "Deer",
                "\uD83E\uDD8C",
                100,
                300,
                20,
                true,
                null,
                4,
                100,
                50
        );
    }

    @Override
    public String  toString() {
        return "Deer{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
