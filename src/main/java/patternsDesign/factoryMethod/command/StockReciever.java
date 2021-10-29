package patternsDesign.factoryMethod.command;

public class StockReciever {

    private String name = "ABC";
    private int quantity = 100;

    public void buy() {
        System.out.println("name = " + name + "quantity = " + quantity + "Comprado");
    }

    public void sell() {
        System.out.println("name = " + name + "quantity = " + quantity + "Vendido");
    }
}
