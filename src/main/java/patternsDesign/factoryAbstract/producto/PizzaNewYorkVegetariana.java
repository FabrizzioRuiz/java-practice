package patternsDesign.factoryAbstract.producto;

import patternsDesign.factoryAbstract.PizzaProducto;

public class PizzaNewYorkVegetariana extends PizzaProducto {

    public PizzaNewYorkVegetariana() {
        //Obligados tenemos que inicializar el constructor del
        //padre el List para tener los ingredientes
        super();
        nombre = "Pizza vegetariana New York";
        masa = "Masa integral vegana";
        salsa = "Salsa de Tomtate";
        ingredientes.add("Queso vegano");
        ingredientes.add("Espinacas");

    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 25min");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza.");
    }
}
