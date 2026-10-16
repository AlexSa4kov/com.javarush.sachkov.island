package main.java.model;


import main.java.constant.AppConstants;
import main.java.model.organism.Plant;
import main.java.model.organism.abstraction.Animal;
import main.java.util.IslandUtils;

import java.util.ArrayList;

public class Island {

    private static Island INSTANCE;
    public static Location [][] location;

    private Island() {
        location = new Location[AppConstants.ISLAND_HEIGHT][AppConstants.ISLAND_WIDTH];
    }

    public static Island getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Island();
        }
        return INSTANCE;
    }

    public void populateIsland() {
        for (int i = 0; i < AppConstants.ISLAND_HEIGHT; i++) {
            for (int j = 0; j < AppConstants.ISLAND_WIDTH; j++) {
                location[i][j] = new Location(new ArrayList<Animal>(), new ArrayList<Plant>());
                IslandUtils.populationOfLocation(location[i][j]);
            }
        }
    }

    public ArrayList<Location> getLocationOfIsland() {
        ArrayList<Location> locationArrayList = new ArrayList<>();
        for (Location[] row : location) {
            for (Location loc : row) {
                locationArrayList.add(loc);
            }
        }
        return locationArrayList;
    }
}
