package threads;

public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();

//        Runnable viaje = new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0; i < 10; i++){
//                    System.out.println(i + " - " + Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                System.out.println("Finalmente me voy de viaje a: " + Thread.currentThread().getName());
//            }
//        };

        //Java8
        Runnable viaje = () -> {
                for(int i=0; i < 10; i++){
                    System.out.println(i + " - " + Thread.currentThread().getName());

                    try {
                        Thread.sleep((long)(Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("Finalmente me voy de viaje a: " + Thread.currentThread().getName());
                System.out.println(main.getState());

        };

        Thread v1 = new Thread(viaje, "Isla de Pascua");
        Thread v2 = new Thread(viaje, "Peru");
        Thread v3 = new Thread(viaje, "Chile");
        Thread v4 = new Thread(viaje, "Ecuador");



        v1.start();
        v2.start();
        v3.start();
        v4.start();

        //Join espera que los Threads finalicen sus procesos
        // Y asi nos aseguramos que se ejecute la intruccion justo cuando terminen los Threads.
        // Los hilos que implementemos dentro del main es un subproceso del main
        v1.join();
        v2.join();
        v3.join();
        v4.join();

        //WAITING
        System.out.println("Continuando con la ejecucion del metodo main: " +main.getName());
    }
}

