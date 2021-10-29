package java8.optional;

import java8.optional.models.Computador;
import java8.optional.repository.Repository;
import java8.optional.repository.ComputadorRepository;
import java.util.Optional;

public class EjemploRepository {
    public static void main(String[] args) {
        Repository<Computador> repo = new ComputadorRepository();

        Optional<Computador> c = repo.filtar("Macbook pro");

        c.ifPresent(computador -> {
            System.out.println(computador.getNombre());
        });

    }
}
