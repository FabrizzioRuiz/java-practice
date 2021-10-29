package patternsDesign.factoryAbstract.producto;

import patternsDesign.factoryAbstract.PizzaProducto;

public class PizzaNewYorkPeperoni extends PizzaProducto {

    public PizzaNewYorkPeperoni() {
        super();
        nombre = "Pizza peperoni";
        masa = "Masa delga a la piedra";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso mozzarella");
        ingredientes.add("Aceitunas");
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
