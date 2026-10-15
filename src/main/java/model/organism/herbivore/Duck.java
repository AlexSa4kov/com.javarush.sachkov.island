package main.java.model.organism.herbivore;

import main.java.model.Location;
import main.java.model.organism.abstraction.Herbivore;

public class Duck extends Herbivore {
    public Duck() {
        super(
                "Duck",
                "\uD83E\uDD86",
                100,
                1,
                200,
                true,
                null,
                4,
                100,
                0.15
        );
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
