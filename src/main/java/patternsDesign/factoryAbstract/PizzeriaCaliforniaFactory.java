package patternsDesign.factoryAbstract;

import patternsDesign.factoryAbstract.producto.PizzaCaliforniaPeperoni;
import patternsDesign.factoryAbstract.producto.PizzaCaliforniaQueso;
import patternsDesign.factoryAbstract.producto.PizzaCaliforniaVegetariana;

public class PizzeriaCaliforniaFactory extends PizzeriaZonaAbstractFactory{
    @Override
    PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto = null;
        switch (tipo){
            case "vegetariano":
                producto = new PizzaCaliforniaVegetariana();
                break;
            case "peperoni":
                producto = new PizzaCaliforniaPeperoni();
                break;
            case "queso":
                producto = new PizzaCaliforniaQueso();
                break;
        }
        return producto;
    }
}
