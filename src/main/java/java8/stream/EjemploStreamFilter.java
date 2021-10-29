package java8.stream;

import java8.lambda.models.Usuario;
import java.util.stream.Stream;

public class EjemploStreamFilter {
    public static void main(String[] args) {

//        Stream<Usuario> nombres = Stream
//                .of("Pato Perez", "Paco Ruiz", "Pepa Luiz", "Pepe Chiri", "Fabri Ruiz")
//                .map( nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
//                .filter(u -> u.getApellidos().equals("Ruiz"))
//                .peek(System.out::println);
//
//        List<Usuario> lista = nombres.collect(Collectors.toList());
//        lista.forEach(System.out::println);


        //####### CAPTURAR UN SOLO OBJETO ##########

        Usuario usuario = Stream
                .of("Pato Perez", "Paco Ruiz", "Pepa Luiz", "Pepe Chiri", "Fabri Ruiz")
                .map( nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .filter(u -> u.getId().equals(5))
                .findFirst().get();

        System.out.println(usuario);







    }
}
