package patternsDesign.factoryMethod.command;

public class BuyStock implements OrderCommand {

    StockReciever stock;

    public BuyStock(StockReciever stock){
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
