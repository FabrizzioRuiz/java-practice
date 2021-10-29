package patternsDesign.composite;

public class PiernaDerAgua extends Componente {

    public PiernaDerAgua(String nombre) {
        super(nombre);
    }

    @Override
    public String logic() {
        return nombre;
    }
}
