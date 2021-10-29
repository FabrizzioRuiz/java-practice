package patternsDesign.factoryAbstract.producto;

import patternsDesign.factoryAbstract.PizzaProducto;

public class PizzaNewYorkItaliana extends PizzaProducto {

    public PizzaNewYorkItaliana() {
        super();
        nombre = "Pizza italina New York";
        masa = "Masa gruesa";
        salsa = "Salsa de tomate con carne";
        ingredientes.add("Queso mozarella");
        ingredientes.add("Jamon y aceitunas");
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
