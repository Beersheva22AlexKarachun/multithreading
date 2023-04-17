package telran.multithreading;

import java.util.Arrays;

public class Race {
    private int members;
    private int distance;
    private volatile int[] array;

    public Race(int members, int distance) {
        this.members = members;
        this.distance = distance;
        array = new int[distance];
    }

    public void start() throws InterruptedException {
        Runner[] runners = new Runner[members];
        for (int i = 0; i < members; i++) {
            runners[i] = new Runner(i + 1, array);
        }
        Arrays.stream(runners).forEach(Thread::start);

        while (array[array.length - 1] == 0) {
        }
        System.out.println(String.format("Member #%d has won.", array[array.length - 1]));

    }
}
