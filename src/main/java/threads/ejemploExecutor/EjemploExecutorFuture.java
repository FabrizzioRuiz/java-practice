package threads.ejemploExecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
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

        Future<?> resultadoFuture = executorService.submit(runnable);
        executorService.shutdown();
        //Espera que se terminen todas las tareas y luego que se detenga el ejecutor para terminar el main
        System.out.println("Continuando con la ejecucion del main");

        System.out.println(resultadoFuture.isDone());
        //Si se demora mas de 2 segundos que lanze la excep\ion


        System.out.println(resultadoFuture.isDone());

    }
}
