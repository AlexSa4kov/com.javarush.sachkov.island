package main.java.model.organism.herbivore;

import main.java.model.organism.abstraction.Herbivore;

public class Mouse extends Herbivore {
    public Mouse() {
        super(
                "Mouse",
                "\uD83D\uDC01",
                100,
                0.05,
                500,
                true,
                null,
                1,
                100,
                0.01
        );
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
