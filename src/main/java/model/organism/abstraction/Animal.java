package main.java.model.organism.abstraction;

import main.java.model.Location;
import main.java.model.organism.herbivore.*;
import main.java.model.organism.predator.*;
import main.java.util.IslandUtils;

public abstract class Animal extends Organism {

    protected int moveInTik;
    protected double currentSatiety;
    protected double satietyLimitPerEating;

    public Animal(
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
    ) {
        super(
                name,
                icon,
                health,
                weight,
                limitInArea,
                isAlive,
                location
        );
        this.moveInTik = moveInTik;
        this.currentSatiety = currentSatiety;
        this.satietyLimitPerEating = satietyLimitPerEating;
    }

    public void move() {
    }

    public void eat() {
    }

    public void multiply() {
        if (!isAlive || location == null) return;

        if (!IslandUtils.hasCapacityForAnimal(location, this)) {
            int countOfPopulation = location.getCountOfCurrentAnimal(this.getClass().getSimpleName());
            if (countOfPopulation >= 2) {
                Animal baby = switch (this.getClass().getSimpleName()) {
                    case "Wolf" -> new Wolf();
                    case "Anaconda" -> new Anaconda();
                    case "Fox" -> new Fox();
                    case "Bear" -> new Bear();
                    case "Eagle" -> new Eagle();
                    case "Horse" -> new Horse();
                    case "Deer" -> new Deer();
                    case "Rabbit" -> new Rabbit();
                    case "Mouse" -> new Mouse();
                    case "Goat" -> new Goat();
                    case "Sheep" -> new Sheep();
                    case "Boar" -> new Boar();
                    case "Buffalo" -> new Buffalo();
                    case "Duck" -> new Duck();
                    //case "Caterpillar" -> new Caterpillar();                  //разобраться с вариантом создания Гусеницы
                    default -> null;
                };

                if (baby != null) {
                    location.addAnimal(baby);
                    baby.setLocation(location);
                }
            }
        }
    }

    //механизм голодания, каждый шаг, если не поел - уровень сытости снижается
    //если сытость на 0 -> животное умирает
    public void starvation() {
        this.currentSatiety -= currentSatiety * 0.2;
        if (this.currentSatiety <= 0) {
            die();
        }
    }
}
