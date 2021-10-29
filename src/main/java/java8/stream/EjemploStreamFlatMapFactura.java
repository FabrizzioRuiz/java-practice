package java8.stream;

import java8.lambda.models.Factura;
import java8.lambda.models.Usuario;

import java.util.Arrays;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {

        Usuario u1 = new Usuario("Fabri", "Ruiz");
        Usuario u2 = new Usuario("Lili", "Chiriguaya");

        u1.addFactura(new Factura("compras tecnologicas"));

        u2.addFactura(new Factura("compras maquillaje"));

        List<Usuario> usuarios = Arrays.asList(u1, u2);

        usuarios.stream()
                .flatMap(u -> u.getFacturas().stream())
                .forEach(f -> System.out.println(f.getDescripcion().concat(" : cliente ")
                .concat(f.getUsuario().toString())));

//        for (Usuario u: usuarios){
//            for (Factura f: u.getFacturas()){
//                System.out.println(f.getDescripcion());
//            }
//        }





    }
}
