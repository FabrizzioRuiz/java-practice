package java8.stream;

import java8.lambda.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjemploStreamParallel {

    public static void main(String[] args) {

        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Andres","Ruiz"));
        lista.add(new Usuario("Africa","Policarpo"));
        lista.add(new Usuario("Roxona","Policarpo"));

        long t1 = System.currentTimeMillis();
        String resultado = lista.stream()
                //.parallel()
                .map(u -> u.toString().toUpperCase())
                .peek( n -> System.out.println("Nombre del hilo " + Thread.currentThread().getName() + "  " + n))
                .flatMap(nombre -> {
                    //Simulacion de una consulta a la base de datos
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (nombre.contains("africa".toUpperCase())){
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .findAny().orElse("");
        long t2 = System.currentTimeMillis();

        System.out.println("Tiempo total:" + (t2-t1));
        System.out.println("resultado = " + resultado);

    }
}
