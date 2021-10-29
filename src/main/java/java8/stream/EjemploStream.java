package java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream {
    public static void main(String[] args) {

//        Stream<String> nombres = Stream.of("Pato", "Paco", "Pepa", "Pepe");
//        nombres.forEach(System.out::println);

//        String[] arr = { "Pato", "Paco", "Pepa", "Pepe" };
//        Stream<String> nombres = Arrays.stream(arr);
//        nombres.forEach(System.out::println);
//
//        Stream<String> nombres = Stream.<String>builder()
//                .add("Pato")
//                .add("Paco")
//                .add("Africa")
//                .add("Fabri")
//                .build();
//
//        nombres.forEach(System.out::println);

        List<String> lista = Arrays.asList("Paco", "Pepe", "Fabri", "Lili");
        lista.stream()
                .forEach(System.out::println);



    }
}
