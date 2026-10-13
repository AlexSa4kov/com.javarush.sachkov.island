package main.java.model;


import main.java.constant.AppConstants;

public class Island {

    private static Island INSTANCE;
    public static Location [][] location;

    private Island() {
        location = new Location[AppConstants.SIDE_X][AppConstants.SIDE_Y];
    }

    public static Island getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Island();
        }
        return INSTANCE;
    }
}
