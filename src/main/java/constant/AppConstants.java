package main.java.constant;

import java.util.Map;

public interface AppConstants {
    int ISLAND_HEIGHT = 2;
    int ISLAND_WIDTH = 2;
    int THREAD_COUNT = 8;
    int STAGE_TIMEOUT_MS = 10;
    int DAY_DELAY_MS = 20;

    Map<String, Integer> ROW_INDEX = Map.ofEntries(
            Map.entry("Wolf", 0),
            Map.entry("Anaconda", 1),
            Map.entry("Fox", 2),
            Map.entry("Bear", 3),
            Map.entry("Eagle", 4),
            Map.entry("Horse", 5),
            Map.entry("Deer", 6),
            Map.entry("Rabbit", 7),
            Map.entry("Mouse", 8),
            Map.entry("Goat", 9),
            Map.entry("Sheep", 10),
            Map.entry("Boar", 11),
            Map.entry("Buffalo", 12),
            Map.entry("Duck", 13),
            Map.entry("Caterpillar", 14)
    );

    Map<String, Integer> COL_INDEX = Map.ofEntries(
            Map.entry("Wolf", 0),
            Map.entry("Anaconda", 1),
            Map.entry("Fox", 2),
            Map.entry("Bear", 3),
            Map.entry("Eagle", 4),
            Map.entry("Horse", 5),
            Map.entry("Deer", 6),
            Map.entry("Rabbit", 7),
            Map.entry("Mouse", 8),
            Map.entry("Goat", 9),
            Map.entry("Sheep", 10),
            Map.entry("Boar", 11),
            Map.entry("Buffalo", 12),
            Map.entry("Duck", 13),
            Map.entry("Caterpillar", 14),
            Map.entry("Plant", 15)
    );

    int[][] MATRIX_OF_CHANCE_EATING = new int[][]{
            {0, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0},  //Волк
            {0, 0, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0},       //Удав
            {0, 0, 0, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40, 0},       //Лиса
            {0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0}, //Медведь
            {0, 0, 10, 0, 0, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0, 0},       //Орел
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},         //Лошадь
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},         //Олень
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},         //Кролик
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},        //Мышь
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},         //Коза
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},         //Овца
            {0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 90, 100},       //Кабан
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},         //Буйвол
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},        //Утка
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},         //Гусеница
    };
}
