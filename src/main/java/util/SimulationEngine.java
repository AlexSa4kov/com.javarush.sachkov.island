package main.java.util;

import main.java.constant.AppConstants;
import main.java.model.Island;
import main.java.model.Location;
import main.java.model.organism.Plant;
import main.java.model.organism.abstraction.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;

public class SimulationEngine {

    private final Island island;
    private final ArrayList<Location> locations;
    private final ScheduledExecutorService scheduledPool;
    private final ExecutorService animalWorkerPool;

    private int day;

    public SimulationEngine() {
        this.island = Island.getInstance();
        this.island.populateIsland();
        this.locations = island.getLocationOfIsland();
        this.scheduledPool = Executors.newScheduledThreadPool(1);
        this.animalWorkerPool = Executors.newFixedThreadPool(AppConstants.THREAD_POOL_SIZE);
        this.day = 0;
    }

    public void start() {
        System.out.println("Симуляция острова запущена!");

        scheduledPool.scheduleAtFixedRate(
                this::runOneDayCycle,
                0,
                AppConstants.DAY_DELAY_MS,
                TimeUnit.MILLISECONDS
        );
    }

    private void runOneDayCycle() {
        try {
            day++;
            System.out.println("\n========== НАЧАЛО ДНЯ " + day + " ==========");

            List<Animal> activeAnimals = collectAllAliveAnimals();
            Collections.shuffle(activeAnimals);

            executeParallelAction(activeAnimals, Animal::move);
            executeParallelAction(activeAnimals, Animal::eat);
            executeParallelAction(activeAnimals, Animal::multiply);

            runPlantGrowth();

            IslandInformation.printDayStatistics(day);

            if (IslandUtils.checkIfAllAnimalsDead(island)) {
                System.out.println("Все животные вымерли.");
                System.out.println("Автоматическая остановка пулов потоков...");
                this.stop();
            }

        } catch (Exception e) {
            System.err.println("Что-то пошло не так с днем...");
            e.printStackTrace();
        }
    }

    private void executeParallelAction(List<Animal> animals, Consumer<Animal> action) {
        List<Callable<Void>> tasks = new ArrayList<>();

        int batchSize = Math.max(1, animals.size() / AppConstants.THREAD_POOL_SIZE);

        for (int i = 0; i < animals.size(); i += batchSize) {
            final List<Animal> subList = animals.subList(i, Math.min(i + batchSize, animals.size()));
            tasks.add(() -> {
                for (Animal animal : subList) {
                    if (animal.isAlive()) {
                        action.accept(animal);
                    }
                }
                return null;
            });
        }

        try {
            animalWorkerPool.invokeAll(tasks, AppConstants.STAGE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println("Фаза симуляции была прервана.");
            Thread.currentThread().interrupt();
        }
    }

    private void runPlantGrowth() {
        for (Location location : locations) {
            for (Plant plant : location.getPlantsCopy()) {
                plant.plantMultiply();
            }
        }
    }

    private List<Animal> collectAllAliveAnimals() {
        List<Animal> allAnimals = new ArrayList<>();
        for (Location loc : locations) {
            for (Animal animal : loc.getAnimalsCopy()) {
                if (animal.isAlive()) {
                    animal.setHasMultiplyInThisDay(false);
                    animal.setHasMovedInThisDay(false);
                    allAnimals.add(animal);
                }
            }
        }
        return allAnimals;
    }

    public void stop() {
        System.out.println("Остановка симуляции...");
        scheduledPool.shutdown();
        animalWorkerPool.shutdown();
        try {
            if (!scheduledPool.awaitTermination(2, TimeUnit.SECONDS)) {
                scheduledPool.shutdownNow();
            }
            if (!animalWorkerPool.awaitTermination(2, TimeUnit.SECONDS)) {
                animalWorkerPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduledPool.shutdownNow();
            animalWorkerPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
