package main.java.model.organisms.predators;


public class Wolf extends Predator {

    public Wolf() {
        super("Волк", 100, 50, 30, 3, 100.0, 8.0);
    }

    @Override
    public String toString() {
        return "Wolf{" +
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
        System.out.println("Вызван метод eat()");
    }

    @Override
    public void move() {
        System.out.println("Вызван метод move()");
    }

    @Override
    public void multiply() {
        System.out.println("Вызван метод multiply()");
    }

    @Override
    public void die() {
        System.out.println("Вызван метод die()");
    }
}
