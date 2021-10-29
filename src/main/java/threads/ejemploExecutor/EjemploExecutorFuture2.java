package threads.ejemploExecutor;

import java.sql.Time;
import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(3);


        Callable<String> tarea = () -> {
            System.out.println("Inicio de la tarea");
            try {
                System.out.println("Nombre de thread" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea");
        return "Devuelve algo importante";
        };

        Callable<Integer> tarea2 = () -> {
            System.out.println("Iniciando tarea 2");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };

        Future<String> resultadoFuture = executorService.submit(tarea);
        Future<String> resultadoFuture2 = executorService.submit(tarea);
        Future<Integer> resultadoFuture3 = executorService.submit(tarea2);

        executorService.shutdown();
        System.out.println("Continuando con la ejecucion del main");

        while (!(resultadoFuture.isDone() && resultadoFuture2.isDone() && resultadoFuture3.isDone() ) ){
            System.out.println(String.format("resultado 1: %s - resultado 2: %s - resultado3: %s",
                    resultadoFuture.isDone()?"finalizo":"en proceso",
                    resultadoFuture2.isDone()?"finalizo":"en proceso",
                    resultadoFuture3.isDone()?"finalizo":"en proceso"
                    ));
            TimeUnit.MILLISECONDS.sleep(1500);
        }

        System.out.println("Obtenemos resultado de la tarea: " + resultadoFuture.get());
        System.out.println(resultadoFuture.isDone());

    }
}
