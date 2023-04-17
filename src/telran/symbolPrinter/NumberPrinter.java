package telran.symbolPrinter;

public class NumberPrinter extends Thread {
    private final int number;
    private final int RUNS;

    public void setNextPrinter(Thread nextPrinter) {
        this.nextPrinter = nextPrinter;
    }

    private Thread nextPrinter;
    private int currRun = 0;
    private String str;

    public NumberPrinter(int number, int amount, int sizeOfPortion) {
        this(number, amount, sizeOfPortion, null);
    }

    public NumberPrinter(int number, int amount, int sizeOfPortion, Thread nextPrinter) {
        this.number = number;
        this.RUNS = amount / sizeOfPortion;
        this.str = String.valueOf(number).repeat(sizeOfPortion);
        this.nextPrinter = nextPrinter;
    }

    @Override
    public void run() {
        while (currRun++ <= RUNS) {
            try {
                join();
            } catch (InterruptedException e) {
                System.out.println(str);
                nextPrinter.interrupt();
            }
        }
    }
}
