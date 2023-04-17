package telran.view;

import telran.multithreading.Race;

public class RoachRaceController {
    static private int MAX_MAMBERS = 100;
    static private int MIN_DISTANCE = 1;
    static private int MAX_DISTANCE = 1000;

    public static Menu getMenu() {
        return new Menu("RoachRace", Item.of("Start game", RoachRaceController::start), Item.exit());
    }

    private static void start(InputOutput io) {
        int members = io.readInt("Enter a number of members:", "Wrong input", 2, MAX_MAMBERS);
        int distance = io.readInt("Enter a distance:", "Wrong input", MIN_DISTANCE, MAX_DISTANCE);

        Race race = new Race(members, distance);
        try {
            race.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
