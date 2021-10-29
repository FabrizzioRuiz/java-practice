package patternsDesign.factoryAbstract.main;

import patternsDesign.factoryAbstract.PizzaProducto;
import patternsDesign.factoryAbstract.PizzeriaCaliforniaFactory;
import patternsDesign.factoryAbstract.PizzeriaNewYorkFactory;
import patternsDesign.factoryAbstract.PizzeriaZonaAbstractFactory;

public class EjemploFactory {
    public static void main(String[] args) {
        //Intentar usar siempre el tipo mas abstracto, generico
        PizzeriaZonaAbstractFactory ny = new PizzeriaNewYorkFactory();
        PizzeriaZonaAbstractFactory california = new PizzeriaCaliforniaFactory();

        //Se crea la pizza en la fabrica, por eso se ordena la pizza directamente
        PizzaProducto pizza = california.ordenarPizza("queso");
        System.out.println("Lili ordena la pizza" + pizza.getNombre());
    }
}
