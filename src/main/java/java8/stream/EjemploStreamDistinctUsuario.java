package java8.stream;

import java8.lambda.models.Usuario;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuario {
    public static void main(String[] args) {

        //####### DISTINC PARA OBJETO ##########

        Stream<Usuario> usuario = Stream
                .of("Pato Perez", "Paco Ruiz", "Pepa Luiz", "Pepe Chiri", "Fabri Ruiz", "Fabri Ruiz")
                .map( nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct();

        usuario.forEach(System.out::println);

        //####### MapToInt ##########

        IntStream largoNombres = Stream
                .of("Pato Perez", "Paco Ruiz", "Pepa Luiz", "Pepe Chiri", "Fabri Ruiz", "Fabri Ruiz")
                .map( nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .mapToInt( u -> u.toString().length() )
                .peek(System.out::println);

//        largoNombres.forEach(System.out::println);
        System.out.println(largoNombres.sum());







    }
}
