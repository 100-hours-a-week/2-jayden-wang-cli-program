import java.util.LinkedList;
import java.util.Queue;

public class OrderManager {
    private Queue<Integer> waitingOrders;
    private int lastOrderNumber;

    public OrderManager() {
        this.waitingOrders = new LinkedList<>();
        this.lastOrderNumber = 0;
    }

    public synchronized int addNewOrder() {
        lastOrderNumber++;
        waitingOrders.add(lastOrderNumber);
        return lastOrderNumber;
    }

    public synchronized int getWaitingCount() {
        return waitingOrders.size();
    }

    public synchronized Integer completeOrder() {
        return waitingOrders.poll();
    }
}
