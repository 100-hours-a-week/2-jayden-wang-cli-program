import food.AdditionalSide;
import food.Burger;
import food.Drink;
import food.Side;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        System.out.println("\n 🍔맥도날드 주문을 시작합니다🍔");
        int burgerChoice;
        while(true) {
            try {
                System.out.println("\n 🔹 1단계: 햄버거를 선택하세요.");
                System.out.println("0)주문 취소");
                for (int i = 0; i < Burger.BURGERS.size(); i++) {
                    Burger burger = Burger.BURGERS.get(i);
                    System.out.println((i + 1) + ")" + burger.getName() + " : " + burger.getPrice());
                }
                System.out.print("선택: ");
                burgerChoice = scanner.nextInt();
                if (burgerChoice == 0) {
                    System.out.println("\n주문이 취소되었습니다.");
                    return;
                }
                if (burgerChoice >= 1 && burgerChoice <= Burger.BURGERS.size()) {
                    break;
                }
                System.out.println("\n ❌ 메뉴에 있는 번호를 선택해주세요.");
            } catch (InputMismatchException e) {
                System.out.println("\n ❌ 숫자를 입력해주세요.");
                scanner.nextLine();
            }
        }
        order.setBurger(Burger.getBurger(burgerChoice));
        scanner.nextLine();

        String setChoice;
        while (true) {
            System.out.println("\n세트로 주문하시겠습니까? (Y/N)");
            setChoice = scanner.nextLine();
            if (setChoice.equalsIgnoreCase("Y") || setChoice.equalsIgnoreCase("N")) {
                break;
            }
            System.out.println("\n ❌ Y 또는 N을 입력해주세요.");
        }
        boolean isSet = setChoice.equalsIgnoreCase("Y");
        order.setSetMenu(isSet);

        if (isSet) {
            int sideChoice;
            while (true) {
                try {
                    System.out.println("\n 🔹 2단계: 사이드를 선택하세요.");
                    System.out.println("0)주문 취소");
                    for (int i = 0; i < Side.SIDES.size(); i++) {
                        Side side = Side.SIDES.get(i);
                        System.out.println((i + 1) + ")" + side.getName() + " : " + side.getPrice());
                    }
                    System.out.print("선택: ");
                    sideChoice = scanner.nextInt();
                    if (sideChoice == 0) {
                        System.out.println("\n주문이 취소되었습니다.");
                        return;
                    }
                    if (sideChoice >= 1 && sideChoice <= Side.SIDES.size()) {
                        break;
                    }
                    System.out.println("\n ❌ 메뉴에 있는 번호를 선택해주세요.");
                } catch (InputMismatchException e) {
                    System.out.println("\n ❌ 숫자를 입력해주세요.");
                    scanner.nextLine();
                }
            }
            order.setSide(Side.getSide(sideChoice));
            scanner.nextLine();

            String additionalChoice;
            while (true) {
                System.out.println("\n추가 사이드 선택을 하시겠습니까? (Y/N)");
                additionalChoice = scanner.nextLine();
                if (additionalChoice.equalsIgnoreCase("Y") || additionalChoice.equalsIgnoreCase("N")) {
                    break;
                }
                System.out.println("\n ❌ Y 또는 N을 입력해주세요.");
            }

            if (additionalChoice.equalsIgnoreCase("Y")) {
                int additionalSideCategoryChoice;
                while (true) {
                    try {
                        System.out.println("\n어떤 추가 사이드 선택을 하시겠습니까?");
                        System.out.println("0)주문 취소");
                        for (int i = 0; i < AdditionalSide.CATEGORIES.size(); i++) {
                            System.out.println((i + 1) + ") " + AdditionalSide.CATEGORIES.get(i));
                        }
                        System.out.print("선택: ");
                        additionalSideCategoryChoice = scanner.nextInt();
                        if (additionalSideCategoryChoice == 0) {
                            System.out.println("\n주문이 취소되었습니다.");
                            return;
                        }
                        if (additionalSideCategoryChoice >= 1 && additionalSideCategoryChoice <= AdditionalSide.CATEGORIES.size()) {
                            break;
                        }
                        System.out.println("\n ❌ 메뉴에 있는 번호를 선택해주세요.");
                    } catch (InputMismatchException e) {
                        System.out.println("\n ❌ 숫자를 입력해주세요.");
                        scanner.nextLine();
                    }
                }
                scanner.nextLine();

                String selectedCategory = AdditionalSide.CATEGORIES.get(additionalSideCategoryChoice - 1);
                List<AdditionalSide> additionalSides = AdditionalSide.getAdditionalSideByCatecory(selectedCategory);

                int additionalSideChoice;
                while (true) {
                    try {
                        System.out.println("\n 🔹 " + selectedCategory + " 메뉴:");
                        System.out.println("0)주문 취소");
                        for (int i = 0; i < additionalSides.size(); i++) {
                            System.out.println((i + 1) + ") " + additionalSides.get(i).getName() + " : " + additionalSides.get(i).getPrice());
                        }
                        System.out.print("선택: ");
                        additionalSideChoice = scanner.nextInt();
                        if (additionalSideChoice == 0) {
                            System.out.println("\n주문이 취소되었습니다.");
                            return;
                        }
                        if (additionalSideChoice >= 1 && additionalSideChoice <= additionalSides.size()) {
                            break;
                        }
                        System.out.println("\n ❌ 메뉴에 있는 번호를 선택해주세요.");
                    } catch (InputMismatchException e) {
                        System.out.println("\n ❌ 숫자를 입력해주세요.");
                        scanner.nextLine();
                    }
                }
                order.setAdditionalSide(additionalSides.get(additionalSideChoice - 1));
                scanner.nextLine();
            }

            int drinkChoice;
            while (true) {
                try {
                    System.out.println("\n 🔹 3단계: 음료를 선택하세요.");
                    System.out.println("0)주문 취소");
                    for (int i = 0; i < Drink.DRINKS.size(); i++) {
                        Drink drink = Drink.DRINKS.get(i);
                        System.out.println((i + 1) + ")" + drink.getName() + " : " + drink.getPrice());
                    }
                    System.out.print("선택: ");
                    drinkChoice = scanner.nextInt();
                    if (drinkChoice == 0) {
                        System.out.println("\n주문이 취소되었습니다.");
                        return;
                    }
                    if (drinkChoice >= 1 && drinkChoice <= Drink.DRINKS.size()) {
                        break;
                    }
                    System.out.println("\n ❌ 메뉴에 있는 번호를 선택해주세요.");
                } catch (InputMismatchException e) {
                    System.out.println("\n ❌ 숫자를 입력해주세요.");
                    scanner.nextLine();
                }
            }
            order.setDrink(Drink.getDrink(drinkChoice));
            scanner.nextLine();
        }

        String confirm;
        while (true) {
            System.out.println("\n주문이 완료되었습니다! 결제하시겠습니까? (Y/N)");
            confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Y") || confirm.equalsIgnoreCase("N")) {
                break;
            }
            System.out.println("\n ❌ Y 또는 N을 입력해주세요.");
        }

        if (confirm.equalsIgnoreCase("Y")) {
            order.checkout();
        } else {
            System.out.println("주문이 취소되었습니다.");
        }

        scanner.close();
    }
}