package java8.stream;

import java8.lambda.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMap {
    public static void main(String[] args) {

//        Stream<String> nombres = Stream
//                .of("Pato", "Paco", "Pepa", "Pepe")
//                .peek(e-> System.out.println(e))
//                .map( nombre -> {
//                    return nombre.toUpperCase();
//                });

        Stream<Usuario> nombres = Stream
                .of("Pato Perez", "Paco Ruiz", "Pepa Luiz", "Pepe Chiri")
                .map( nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(u -> System.out.println(u.getNombre()))
                .map(usuario -> {
                    String nombre = usuario.getNombre().toLowerCase();
                    usuario.setNombre(nombre);
                    return usuario;
                });

        List<Usuario> lista = nombres.collect(Collectors.toList());
        lista.forEach(u -> System.out.println(u.getNombre()));





    }
}
