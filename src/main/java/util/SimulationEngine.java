package main.java.util;

import main.java.constant.AppConstants;
import main.java.model.Island;
import main.java.model.Location;
import main.java.model.organism.Plant;
import main.java.model.organism.abstraction.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SimulationEngine {

    private final Island island;
    private final ArrayList<Location> locations;
    private final ScheduledExecutorService scheduledPool;
    private final ExecutorService executor;
    private int day;

    public SimulationEngine() {
        this.island = Island.getInstance();
        this.island.populateIsland();
        this.locations = island.getLocationOfIsland();
        this.scheduledPool = Executors.newScheduledThreadPool(1);
        this.executor = Executors.newFixedThreadPool(AppConstants.THREAD_POOL_SIZE);
        this.day = 0;
    }

    public void start() {
        System.out.println("Симуляция острова запущена!");
        try {
            while (!Thread.currentThread().isInterrupted()) {
                day++;
                System.out.println("\n========== НАЧАЛО ДНЯ " + day + " ==========");

                runMoveTask();
                resetFlagOfParticipation();
                runEatTask();
                resetFlagOfParticipation();
                runMultiplyTask();
                resetFlagOfParticipation();
                runPlantGrowthTask();

                IslandInformation.printDayStatistics(day);

                Thread.sleep(AppConstants.DAY_DELAY_MS);
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
        executor.invokeAll(tasks, AppConstants.STAGE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
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
        executor.invokeAll(tasks, AppConstants.STAGE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
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
        executor.invokeAll(tasks, AppConstants.STAGE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
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
        executor.invokeAll(tasks, AppConstants.STAGE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    public void resetFlagOfParticipation() {
        ArrayList<Location> locations = Island.getInstance().getLocationOfIsland();
        for (Location loc : locations) {
            for (Animal animal : loc.getAnimalsCopy()) {
                if (animal.isAlive()) {
                    animal.setParticipation(false); // Готовим к следующему дню
                }
            }
        }
    }

}
