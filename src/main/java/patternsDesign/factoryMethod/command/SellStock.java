package patternsDesign.factoryMethod.command;

public class SellStock implements OrderCommand {

    private StockReciever stock;

    public SellStock(StockReciever stock){
        this.stock= stock;
    }


    @Override
    public void execute() {
        stock.sell();
    }
}
