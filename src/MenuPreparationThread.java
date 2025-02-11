public class MenuPreparationThread extends Thread{
    private final String menuType;
    private final String menuName;
    private final int orderNumber;
    private final int preparationTime;

    public MenuPreparationThread(String menuType, String menuName, int orderNumber, int preparationTime) {
        this.menuType = menuType;
        this.menuName = menuName;
        this.orderNumber = orderNumber;
        this.preparationTime = preparationTime;
    }

    @Override
    public void run() {
        try {
            System.out.println("\n" + menuType + " 준비 시작 (" + orderNumber + "번 주문) : " + menuName);
            Thread.sleep(preparationTime);
            System.out.println("\n✅ " + menuType + " 준비 완료 (" + orderNumber + "번 주문): " + menuName);
        } catch (InterruptedException e) {
            System.out.println(menuType + " 준비 중단: " + menuName);
        }
    }
}
