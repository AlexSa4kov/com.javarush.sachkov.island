package main.java;

import main.java.util.IslandInformation;
import main.java.util.SimulationEngine;

public class  Application {
    public static void main(String[] args) {

        IslandInformation.printStartInformation();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        SimulationEngine engine = new SimulationEngine();
        engine.start();
    }
}

