package patternsDesign.factoryMethod.command;

public class Main {
    public static void main(String[] args) {
        StockReciever stock = new StockReciever();

        OrderCommand buyStockOrder = new BuyStock(stock);
        OrderCommand sellStockOrder = new SellStock(stock);

        BrokerInvoker broker = new BrokerInvoker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();

    }
}
