package main.java.model;


import main.java.constant.AppConstants;

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
}
