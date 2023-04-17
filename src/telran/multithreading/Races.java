package telran.multithreading;


public class Races {
    public static void main(String[] args) throws InterruptedException {
//        Menu menu = RoachRaceController.getMenu();
//        menu.perform(new StandardInputOutput());
        new Race(10, 10).start();
    }
}
