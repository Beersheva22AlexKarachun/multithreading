package telran.printers;

import java.io.IOException;
import java.util.Scanner;

public class SymbolPrinterController {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        SymbolPrinter printer = new SymbolPrinter("qwerty123");
        printer.start();
        while (!sc.nextLine().equals("q")) {
            printer.interrupt();
        }
    }
}
