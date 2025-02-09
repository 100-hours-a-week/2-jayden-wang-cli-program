import food.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuSelector menuSelector = new MenuSelector(scanner);
        Order order = new Order();

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

        if (menuSelector.selectYesNo("주문이 완료되었습니다! 결제하시겠습니까?")) {
            order.checkout();
        } else {
            System.out.println("주문이 취소되었습니다.");
        }

        scanner.close();
    }
}