package main.java.util;

import main.java.model.Island;
import main.java.model.Location;
import main.java.model.organism.Plant;
import main.java.model.organism.abstraction.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {
    private static final int THREAD_COUNT = 4;
    private static final int STAGE_TIMEOUT_MS = 250;
    private static final int DAY_DELAY_MS = 1000;

    private final Island island;
    private final ArrayList<Location> locations;
    private final ExecutorService executor;
    private int day;

    public SimulationEngine() {
        this.island = Island.getInstance();
        this.island.populateIsland();
        this.locations = island.getLocationOfIsland();
        this.executor = Executors.newFixedThreadPool(THREAD_COUNT);
        this.day = 0;
    }

    public void start() {
        System.out.println("Симуляция острова запущена!");
        try {
            while (!Thread.currentThread().isInterrupted()) {
                day++;
                System.out.println("\n========== НАЧАЛО ДНЯ " + day + " ==========");

                runMoveTask();
                runEatTask();
                runMultiplyTask();
                runStarvationTask();
                runPlantGrowthTask();

                IslandInformation.printDayStatistics(day);

                Thread.sleep(DAY_DELAY_MS);
            }
        } catch (InterruptedException e) {
            System.out.println("Симуляция была остановлена.");
        } finally {
            stop();
        }
    }

    public void stop() {
        if (!executor.isShutdown()) {
            executor.shutdown();
            System.out.println("Пул потоков симуляции успешно остановлен.");
        }
    }

    private void runMoveTask() throws InterruptedException {
        List<Callable<Void>> tasks = new ArrayList<>();
        for (Location location : locations) {
            tasks.add(() -> {
                for (Animal animal : location.getAnimalsCopy()) {
                    if (Thread.currentThread().isInterrupted()) break;
                    animal.move();
                }
                return null;
            });
        }
        executor.invokeAll(tasks, STAGE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    private void runEatTask() throws InterruptedException {
        List<Callable<Void>> tasks = new ArrayList<>();
        for (Location location : locations) {
            tasks.add(() -> {
                for (Animal animal : location.getAnimalsCopy()) {
                    if (Thread.currentThread().isInterrupted()) break;
                    animal.eat();
                }
                return null;
            });
        }
        executor.invokeAll(tasks, STAGE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    private void runMultiplyTask() throws InterruptedException {
        List<Callable<Void>> tasks = new ArrayList<>();
        for (Location location : locations) {
            tasks.add(() -> {
                for (Animal animal : location.getAnimalsCopy()) {
                    if (Thread.currentThread().isInterrupted()) break;
                    animal.multiply();
                }
                return null;
            });
        }
        executor.invokeAll(tasks, STAGE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    private void runStarvationTask() throws InterruptedException {
        List<Callable<Void>> tasks = new ArrayList<>();
        for (Location location : locations) {
            tasks.add(() -> {
                for (Animal animal : location.getAnimalsCopy()) {
                    if (Thread.currentThread().isInterrupted()) break;
                    animal.starvation();
                }
                return null;
            });
        }
        executor.invokeAll(tasks, STAGE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    private void runPlantGrowthTask() throws InterruptedException {
        List<Callable<Void>> tasks = new ArrayList<>();
        for (Location location : locations) {
            tasks.add(() -> {
                for (Plant plant : location.getPlantsCopy()) {
                    if (Thread.currentThread().isInterrupted()) break;
                    plant.plantMultiply();
                }
                return null;
            });
        }
        executor.invokeAll(tasks, STAGE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

}
