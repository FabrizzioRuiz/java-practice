package patternsDesign.factoryAbstract;

import patternsDesign.factoryAbstract.producto.PizzaNewYorkItaliana;
import patternsDesign.factoryAbstract.producto.PizzaNewYorkPeperoni;
import patternsDesign.factoryAbstract.producto.PizzaNewYorkVegetariana;

public class PizzeriaNewYorkFactory  extends PizzeriaZonaAbstractFactory{
    @Override
    PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto = null;
        switch (tipo){
            case "vegetariana" :
                producto = new PizzaNewYorkVegetariana();
                break;
            case "peperoni":
                producto = new PizzaNewYorkPeperoni();
                break;
            case "italiana":
                producto = new PizzaNewYorkItaliana();
                break;
        }
        return producto;
    }
}
