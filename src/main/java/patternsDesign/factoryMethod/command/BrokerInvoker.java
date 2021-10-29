package patternsDesign.factoryMethod.command;

import java.util.ArrayList;
import java.util.List;

public class BrokerInvoker {

    private List<OrderCommand> orders = new ArrayList<>();

    public void takeOrder(OrderCommand order){
        this.orders.add(order);
    }

    public void placeOrders(){
        for(OrderCommand order : orders){
            order.execute();
        }
        orders.clear();
    }
}
