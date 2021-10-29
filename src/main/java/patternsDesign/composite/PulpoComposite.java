package patternsDesign.composite;

import java.util.ArrayList;
import java.util.List;

public class PulpoComposite extends Componente {

    private List<Componente> hijos;

    public PulpoComposite(String nombre) {
        super(nombre);
        this.hijos = new ArrayList<>();
        hijos.add(new PiernaDerAgua("agua!!"));
        hijos.add(new PiernaIzqFuego("fuegoo!!"));
    }

    public PulpoComposite addComposite(Componente c){
        hijos.add(c);
        return this;
    }

    public void eliminarComposite(Componente c){
        hijos.remove(c);
    }

    public Componente getChild(int index) {
        return hijos.get(index);
    }

    @Override
    public String logic() {
        StringBuffer sb = new StringBuffer();


        for (Componente hijo : this.hijos) {
            sb.append(hijo.logic());
        }
        return sb.toString();
    }

}
