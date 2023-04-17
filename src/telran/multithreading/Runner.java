package telran.multithreading;

import java.util.Random;

public class Runner extends Thread {
    private static Random rd = new Random();
    static private final int MIN_DELAY = 1;
    static private final int MAX_DELAY = 10;

    private int number;
    private int[] array;


    public Runner(int number, int[] array) {
        this.number = number;
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            array[i] = number;
            try {
                Thread.sleep(rd.nextInt(MIN_DELAY, MAX_DELAY));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
