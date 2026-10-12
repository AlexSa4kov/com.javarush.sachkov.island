package main.java.util;

public class IslandStats {
    private final long plantCount;
    private final long predatorCount;
    private final long herbivoreCount;

    public IslandStats(long plantCount, long predatorCount, long herbivoreCount) {
        this.plantCount = plantCount;
        this.predatorCount = predatorCount;
        this.herbivoreCount = herbivoreCount;
    }

    public long getPlantCount() { return plantCount; }
    public long getPredatorCount() { return predatorCount; }
    public long getHerbivoreCount() { return herbivoreCount; }

    public long getAnimalCount() {
        return predatorCount + herbivoreCount;
    }

    public long getTotalCount() {
        return plantCount + getAnimalCount();
    }
}
