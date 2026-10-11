package main.java.model.organisms.herbivores;

public class Horse extends Herbivore {

    public Horse(String name, int health, int weight, int limitOfAnimalsInArea, int limitOfMoved, double currentSatiety, double satietyLimit) {
        super("Лошадь", 100, 400, 20, 4, 100, 60);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", weight=" + weight +
                ", limitOfAnimalsInArea=" + limitOfAnimalsInArea +
                ", limitOfMoved=" + limitOfMoved +
                ", currentSatiety=" + currentSatiety +
                ", satietyLimitPerEating=" + satietyLimitPerEating +
                '}';
    }

    @Override
    public void eat() {

    }

    @Override
    public void move() {

    }

    @Override
    public void multiply() {

    }

    @Override
    public void die() {

    }
}
