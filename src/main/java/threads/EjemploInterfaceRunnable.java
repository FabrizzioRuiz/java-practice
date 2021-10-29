package threads;

import threads.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) {
        new Thread(new ViajeTarea("Isla de Pascua")).start();
        new Thread(new ViajeTarea("Peru")).start();
        new Thread(new ViajeTarea("Chile")).start();
        new Thread(new ViajeTarea("Ecuador")).start();
    }
}
