package threads.ejemploExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Runnable runnable = () -> {
            System.out.println("Inicio de la tarea");
            try {
                System.out.println("Nombre de thread" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea");

        };

        executorService.submit(runnable);
        executorService.shutdown();
        //Espera que se terminen todas las tareas y luego que se detenga el ejecutor para terminar el main
        System.out.println("Continuando con la ejecucion del main");
        executorService.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Continuando con la ejecucion del main2");

    }
}
