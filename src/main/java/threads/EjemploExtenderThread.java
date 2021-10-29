package threads;

import threads.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) {
        Thread hilo = new NombreThread("Fabrizzio");
        hilo.start();

        Thread hilo2 = new NombreThread("Lili");
        hilo2.start();

        Thread hilo3 = new NombreThread("Pepe");
        hilo3.start();
        //Es una pause en el main no en el hilo
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(hilo.getState());
    }
}
