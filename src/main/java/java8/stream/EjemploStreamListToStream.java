package java8.stream;

import java8.lambda.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamListToStream {

    public static void main(String[] args) {

        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Andres","Ruiz"));
        lista.add(new Usuario("Africa","Policarpo"));
        lista.add(new Usuario("Roxona","Policarpo"));

        lista.stream()
                .map(u -> u.getNombre().toUpperCase()
                .concat(" ")
                .concat(u.getApellidos().toUpperCase()))
                .flatMap(nombre -> {
                    if (nombre.contains("africa".toUpperCase())){
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .forEach(System.out::println);


    }
}
