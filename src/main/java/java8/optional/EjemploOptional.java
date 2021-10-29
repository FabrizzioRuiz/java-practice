package java8.optional;

import java.util.Optional;

public class EjemploOptional {

    public static void main(String[] args) {

        String nombre = "Fabrizzio";

        Optional<String> opt = Optional.of(nombre);

//        System.out.println("opt = " + opt);
//        System.out.println(opt.isPresent());

//        if (opt.isPresent()){
//            System.out.println("Hola " + opt.get());
//        }

        opt.ifPresent(v-> {
            System.out.println("Hola " + v);
        }  );

        nombre = null;

        opt = Optional.ofNullable(nombre);
        System.out.println("opt = " + opt);
        opt.ifPresentOrElse(valor -> System.out.println("Hola " + valor), () -> {
            System.out.println("No esta presente");
        });

    }

}
