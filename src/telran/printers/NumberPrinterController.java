package telran.printers;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;

public class NumberPrinterController {
    public static final int amountOfPrinters = 3;
    public static final int amountOfNumbers = 30;
    public static final int sizeOfPortion = 10;

    public static void main(String[] args) {
        NumberPrinter[] printers = new NumberPrinter[amountOfPrinters];

        printers[printers.length - 1] = new NumberPrinter(printers.length, amountOfNumbers, sizeOfPortion);
        for (int i = printers.length - 2; i > -1; i--) {
            printers[i] = new NumberPrinter(i + 1, amountOfNumbers, sizeOfPortion, printers[i + 1]);
        }

        printers[printers.length - 1].setNextPrinter(printers[0]);

        Arrays.stream(printers).forEach(Thread::start);
        printers[0].interrupt();
    }
}
