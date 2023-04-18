package telran.printers;

public class SymbolPrinter extends Thread {
    private static final String DEFAULT_STRING = "HelloWorld";
    private static final int DEFAULT_TIMEOUT = 1000;

    private String symbols;
    private int timeout;

    public SymbolPrinter() {
        this(DEFAULT_STRING, DEFAULT_TIMEOUT);
    }

    public SymbolPrinter(String symbols) {
        this(symbols, DEFAULT_TIMEOUT);
    }

    public SymbolPrinter(String symbols, int timeout) {
        setDaemon(true);
        this.symbols = symbols;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        int index = 0;

        while (true) {
            System.out.println(symbols.charAt(index));
            try {
                sleep(timeout);
            } catch (InterruptedException e) {
                index = (index == symbols.length() - 1) ? 0 : ++index;
            }
        }
    }

}
