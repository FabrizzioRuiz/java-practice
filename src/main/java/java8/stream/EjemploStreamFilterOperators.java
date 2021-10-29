package java8.stream;


import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamFilterOperators {
    public static void main(String[] args) {

        //########### EMPTY ################
        System.out.println("EMPTY");
        long count = Stream
                .of("Pato Perez", "Paco Ruiz", "", "Pepa Luiz", "Pepe Chiri", "Fabri Ruiz", "")
                .filter(String::isEmpty)
                //.peek(System.out::println)
                .count();
        System.out.println("count = " + count);

        //########### DISTINCT ################
        System.out.println("DISTINCT");
        Stream<String> nombres = Stream
        .of("Pato Perez", "Paco Ruiz", "", "Pepa Luiz", "Pepe Chiri", "Fabri Ruiz", "Fabri Ruiz")
                .distinct(); //Para quitar elementos repetidos de una lista

        nombres.forEach(System.out::println);

        //########### REDUCE ################
        System.out.println("REDUCE");
        Stream<String> nombres2 = Stream
                .of("Pato Perez", "Paco Ruiz", "", "Pepa Luiz", "Pepe Chiri", "Fabri Ruiz", "Fabri Ruiz")
                .distinct(); //Para quitar elementos repetidos de una lista

        String resultado = nombres2.reduce("resultado = ", (a, b) -> a+ ", " +b);
        System.out.println(resultado);

        //########### REDUCE2 ################
        System.out.println("REDUCE2");
        Stream<Integer> nombres3 = Stream
                .of(5, 10, 15, 20);

        int resultado2 = nombres3.reduce(0, Integer::sum); // (a, b) -> a+b
        System.out.println(resultado2);

        //########### RANGO ################
        System.out.println("REDUCE3");
        IntStream num = IntStream
//                .range(5, 10)
                .rangeClosed(5, 10)
                .peek(System.out::println);

//        int resultado4 = nombres4.reduce(0, Integer::sum); // (a, b) -> a+b
//        int resultado4 = num.sum(); // (a, b) -> a+b
        IntSummaryStatistics resultado4 = num.summaryStatistics(); // (a, b) -> a+b
        System.out.println("max = " + resultado4.getMax());
        System.out.println("promedio = " + resultado4.getAverage());

        System.out.println("Todo " + resultado4.toString());









    }
}
