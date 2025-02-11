import order.Order;
import order.OrderQueue;
import food.*;
import thread.MenuPreparationThread;
import thread.OtherCustomersThread;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuSelector menuSelector = new MenuSelector(scanner);
        Order order = new Order();
        OrderQueue orderQueue = new OrderQueue();

        OtherCustomersThread otherCustomers = new OtherCustomersThread(orderQueue);
        otherCustomers.setDaemon(true);
        otherCustomers.start();

        System.out.println("\n 🍔맥도날드 주문을 시작합니다🍔");

        Burger selectedBurger = menuSelector.selectMenuItem(
                "🔹 1단계: 햄버거를 선택하세요.",
                Burger.BURGERS,
                Item::getName,
                Item::getPrice
        );
        order.setBurger(selectedBurger);

        boolean isSet = menuSelector.selectYesNo("세트로 주문하시겠습니까?");
        order.setSetMenu(isSet);

        if (isSet) {
            Side selectedSide = menuSelector.selectMenuItem(
                    "🔹 2단계: 사이드를 선택하세요.",
                    Side.SIDES,
                    Item::getName,
                    Item::getPrice
            );
            order.setSide(selectedSide);

            if (menuSelector.selectYesNo("추가 사이드 선택을 하시겠습니까?")) {
                String selectedCategory = menuSelector.selectMenuItem(
                        "어떤 추가 사이드 선택을 하시겠습니까?",
                        AdditionalSide.CATEGORIES,
                        category -> category,
                        category -> 0
                );

                List<AdditionalSide> additionalSides = AdditionalSide.getAdditionalSideByCatecory(selectedCategory);
                AdditionalSide selectedAdditionalSide = menuSelector.selectMenuItem(
                        "🔹 " + selectedCategory + " 메뉴:",
                        additionalSides,
                        Item::getName,
                        Item::getPrice
                );
                order.setAdditionalSide(selectedAdditionalSide);
            }

            Drink selectedDrink = menuSelector.selectMenuItem(
                    " 🔹 3단계: 음료를 선택하세요.",
                    Drink.DRINKS,
                    Item::getName,
                    Item::getPrice
            );
            order.setDrink(selectedDrink);
        }

        if (menuSelector.selectYesNo("주문을 완료하시겠습니까?")) {
            int myOrderNum = orderQueue.addNewOrder();

            order.checkout();
            System.out.println("\n고객님의 주문번호는 " + myOrderNum + "번 입니다.");
            System.out.println("대기중인 주문 개수는 " + orderQueue.getWaitingCount() + "개입니다.");

            new MenuPreparationThread("🍔 버거", order.getBurger().getName(), myOrderNum, 3000 + new Random().nextInt(2000)).start();

            if (isSet) {
                new MenuPreparationThread("🍟 사이드", order.getSdie().getName(), myOrderNum, 2000 + new Random().nextInt(2000)).start();
                new MenuPreparationThread("🥤 음료", order.getDrink().getName(), myOrderNum, 1000).start();
            }
        } else {
            System.out.println("주문이 취소되었습니다.");
        }

        scanner.close();
    }
}