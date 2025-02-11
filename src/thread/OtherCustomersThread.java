package thread;

import order.OrderQueue;

import java.util.Random;

public class OtherCustomersThread extends Thread{
    private final OrderQueue orderQueue;

    public OtherCustomersThread(OrderQueue orderQueue) {
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000 + new Random().nextInt(2000));
    
                orderQueue.addNewOrder();
    
                if(new Random().nextInt(100) < 30) {
                    orderQueue.completeOrder();
                }
                
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
