package main.java.model;

import static main.java.constant.AppConstants.SIDE_X;
import static main.java.constant.AppConstants.SIDE_Y;

public class Island {

    private static Island INSTANCE;
    public static Location [][] location;

    private Island() {
        location = new Location[SIDE_X][SIDE_Y];
    }

    public static Island getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Island();
        }
        return INSTANCE;
    }
}
