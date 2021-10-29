package patternsDesign.composite;

import java.util.Objects;

abstract public class Componente {

    protected String nombre;

    public Componente(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    abstract public String logic();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Componente componente = (Componente) o;
        return Objects.equals(nombre, componente.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
