package java8.optional.repository;

import java8.optional.models.Computador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ComputadorRepository implements Repository<Computador> {

    List<Computador> dataSource;

    public ComputadorRepository() {
        dataSource = new ArrayList<>();
        dataSource.add(new Computador("Macbook pro", "2018"));
        dataSource.add(new Computador("Asu gus", "Algun modelo tendra"));
    }

    @Override
    public Optional<Computador> filtar(String nombre) {
       for (Computador data: dataSource){
           if (data.getNombre().equalsIgnoreCase(nombre)){
               return Optional.of(data);
           }
       }
        return Optional.empty();
    }
}
