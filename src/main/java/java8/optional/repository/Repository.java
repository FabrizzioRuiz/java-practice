package java8.optional.repository;


import java8.optional.models.Computador;

import java.util.Optional;

public interface Repository<T> {

    Optional<Computador> filtar(String nombre);
}
