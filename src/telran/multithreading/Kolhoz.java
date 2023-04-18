package telran.multithreading;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Kolhoz {

    private static final int N_TRUCKS = 1_000;
    private static final int N_RUNS = 100_000;

    public static void main(String[] args) {
        Truck[] trucks = new Truck[N_TRUCKS];
        startTrucks(trucks);
        Instant start = Instant.now();
        waitTrucks(trucks);
        displayResult(start);
    }

    private static void displayResult(Instant start) {
        System.out.printf("Running time %dms, elevator1 %s, elevator2 %s\n",
                ChronoUnit.MILLIS.between(start, Instant.now()),
                Truck.getElevator1(),
                Truck.getElevator2());
    }

    private static void waitTrucks(Truck[] trucks) {
        Arrays.stream(trucks).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
            }
        });
    }

    private static void startTrucks(Truck[] trucks) {
        for (int i = 0; i < trucks.length; i++) {
            trucks[i] = new Truck(N_RUNS);
            trucks[i].start();
        }
    }
}