package telran.multithreading;

public class Truck extends Thread {
    private static long elevator1;
    private static long elevator2;
    public static final int DEFAULT_LOAD = 1;
    private static final Object mutex = new Object();

    private int load;
    private int nRuns;

    public Truck(int load, int nRuns) {
        this.load = load;
        this.nRuns = nRuns;
    }

    public Truck(int nRuns) {
        this(DEFAULT_LOAD, nRuns);
    }

    public static long getElevator1() {
        return elevator1;
    }

    public static long getElevator2() {
        return elevator2;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRuns; i++) {
            loadElevator1(load);
            loadElevator2(load);
        }
    }

    private static void loadElevator1(int load) {
        synchronized (mutex) {
            elevator1 += load;
        }
    }

    private static synchronized void loadElevator2(int load) {
        elevator2 += load;
    }

}