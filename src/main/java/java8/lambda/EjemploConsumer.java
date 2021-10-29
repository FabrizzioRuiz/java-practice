package java8.lambda;


import java8.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {

        Consumer<Date> consumer = fecha -> {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(f.format(fecha));
        };

        consumer.accept(new Date());
        //EL Bi consumer no devuelve nada solo realiza alguna implementacion
        BiConsumer<String, Integer> consumidorBi = (nombre, edad) -> {
            System.out.println(nombre + ", tiene " + edad + " anios");
        };

        consumidorBi.accept("fabri", 24);

        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("Hola mundo");

        //Mas rapido que instanciar y usar el add
        List<String> nombres = Arrays.asList("fabri", "lili", "africa");

        nombres.forEach(consumidor2);

        Supplier<Usuario> creaUsuario = Usuario::new; // () -> new Usuario();
        Usuario usuario = creaUsuario.get();



        //############# REFERENCIA DE METODO ####################//

        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre; // (persona, nombre) -> persona.setNombre(nombre);

        asignarNombre.accept(usuario, "Adolfo");

        System.out.println("Nombre de usuario " + usuario.getNombre());

        //SUPLIER solo devuelve
        Supplier<String> proveedor = ()-> "Hola proveedor";

        System.out.println(proveedor.get());
    }
}
