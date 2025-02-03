import food.*;

public class Order {
    private Burger burger;
    private Side side;
    private AdditionalSide additionalSide;
    private Drink drink;
    private boolean isSet = false;

    public void setBurger(Burger burger) {
        this.burger = burger;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public void setAdditionalSide(AdditionalSide additionalSide) {
        this.additionalSide = additionalSide;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public void setSetMenu(boolean isSet) {
        this.isSet = isSet;
    }

    public void showOrder() {
        System.out.println("\n===== 주문 목록 =====");
        int totalPrice = 0;

        if (burger != null) {
            System.out.println("- " + burger.getName() + " : " + burger.getPrice());
            totalPrice += burger.getPrice();
        }
        if (isSet) {
            if (side != null) {
                System.out.println("- " + side.getName() + " : " + side.getPrice());
                totalPrice += side.getPrice();
            }
            if (additionalSide != null) {
                System.out.println("- 추가 선택: " + additionalSide.getName() + " (" + additionalSide.getCategory() + "): " + additionalSide.getPrice());
                totalPrice += additionalSide.getPrice();
            }
            if (drink != null) {
                System.out.println("- " + drink.getName() + " : " + drink.getPrice());
                totalPrice += drink.getPrice();
            }

            System.out.println("- 세트 추가 : " + (int) (totalPrice * 0.5));
            totalPrice = (int) (totalPrice * 1.5);
        }

        System.out.println("총 가격 : " + totalPrice);
    }

    public void checkout() {
        if (burger == null) {
            System.out.println("모든 메뉴를 선택해야 합니다!");
            return;
        }
        showOrder();
        System.out.println("주문이 완료되었습니다. 감사합니다!");
    }
}
