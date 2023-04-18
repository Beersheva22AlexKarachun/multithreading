package telran.printers;

public class NumberPrinter extends Thread {
    private final int number;
    private int runs;

    public void setNextPrinter(Thread nextPrinter) {
        this.nextPrinter = nextPrinter;
    }

    private Thread nextPrinter;
    private String portion;

    public NumberPrinter(int number, int amount, int sizeOfPortion) {
        this(number, amount, sizeOfPortion, null);
    }

    public NumberPrinter(int number, int amount, int sizeOfPortion, Thread nextPrinter) {
        this.number = number;
        this.runs = amount / sizeOfPortion;
        this.portion = (number + " ").repeat(sizeOfPortion).strip();
        this.nextPrinter = nextPrinter;
    }

    @Override
    public void run() {
        for (int i = 0; i < runs; i++) {
            try {
                join();
            } catch (InterruptedException e) {
                System.out.println(portion);
                nextPrinter.interrupt();
            }
        }
    }
}