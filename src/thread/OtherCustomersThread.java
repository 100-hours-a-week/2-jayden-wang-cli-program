package thread;

import order.OrderManager;

import java.util.Random;

public class OtherCustomersThread extends Thread{
    private final OrderManager orderManager;

    public OtherCustomersThread(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000 + new Random().nextInt(2000));
    
                orderManager.addNewOrder();
    
                if(new Random().nextInt(100) < 30) {
                    orderManager.completeOrder();
                }
                
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
