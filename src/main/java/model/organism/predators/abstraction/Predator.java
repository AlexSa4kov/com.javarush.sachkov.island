package main.java.model.organism.predators.abstraction;


import main.java.model.Location;
import main.java.model.organism.Animal;

public abstract class Predator extends Animal {


    public Predator(
            String name,
            String icon,
            int health,
            double weight,
            int limitInArea,
            boolean isAlive,
            Location location,
            int moveInTik,
            double currentSatiety,
            double satietyLimitPerEating
    )
    {
        super(
                name,
                icon,
                health,
                weight,
                limitInArea,
                isAlive,
                location,
                moveInTik,
                currentSatiety,
                satietyLimitPerEating
        );
    }
}
