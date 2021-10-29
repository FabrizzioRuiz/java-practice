package patternsDesign.composite;

public class PiernaIzqFuego extends Componente {

    public PiernaIzqFuego(String nombre) {
        super(nombre);
    }

    @Override
    public String logic() {
        return nombre;
    }
}
