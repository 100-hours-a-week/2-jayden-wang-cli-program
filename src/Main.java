import food.AdditionalSide;
import food.Burger;
import food.Drink;
import food.Side;

import java.util.List;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        System.out.println("\n 🍔맥도날드 주문을 시작합니다🍔");

        System.out.println("🔹 1단계: 햄버거를 선택하세요.");
        System.out.println("1) 치즈버거 : 3000");
        System.out.println("2) 불고기버거 : 3500");
        System.out.println("3) 빅맥 : 5000");
        System.out.println("4) 1955버거 : 6000");
        System.out.println("5) 베이컨 토마토 디럭스 버거 : 7000");
        System.out.print("선택: ");
        int burgerChoice = scanner.nextInt();
        order.setBurger(Burger.getBurger(burgerChoice));
        scanner.nextLine();

        System.out.println("\n세트로 주문하시겠습니까? (Y/N)");
        String setChoice = scanner.nextLine();
        boolean isSet = setChoice.equalsIgnoreCase("Y");
        order.setSetMenu(isSet);

        if (isSet) {
            System.out.println("\n🔹 2단계: 사이드를 선택하세요.");
            System.out.println("1) 감자튀김 S : +0");
            System.out.println("2) 감자튀김 L : +500");
            System.out.print("선택: ");
            int sideChoice = scanner.nextInt();
            order.setSide(Side.getSide(sideChoice));
            scanner.nextLine();

            System.out.println("\n추가 사이드 선택을 하시겠습니까? (Y/N)");
            String additionalChoice = scanner.nextLine();
            if (additionalChoice.equalsIgnoreCase("Y")) {
                System.out.println("\n어떤 추가 사이드 선택을 하시겠습니까?");
                System.out.println("1) 토핑");
                System.out.println("2) 소스");
                System.out.println("3) 맥플러리");
                System.out.print("선택: ");
                int categoryChoice = scanner.nextInt();
                scanner.nextLine();

                String selectedCategory = switch (categoryChoice) {
                    case 1 -> "토핑";
                    case 2 -> "소스";
                    case 3 -> "맥플러리";
                    default -> "";
                };

                if (!selectedCategory.isEmpty()) {
                    List<AdditionalSide> additionalSides = AdditionalSide.getAdditionalSideByCatecory(selectedCategory);

                    System.out.println("\n🔹 " + selectedCategory + " 메뉴:");
                    for (int i = 0; i < additionalSides.size(); i++) {
                        System.out.println((i + 1) + ") " + additionalSides.get(i).getName() + " : " + additionalSides.get(i).getPrice());
                    }

                    System.out.print("선택: ");
                    int additionalSideChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (additionalSideChoice >= 1 && additionalSideChoice <= additionalSides.size()) {
                        order.setAdditionalSide(additionalSides.get(additionalSideChoice - 1));
                    } else {
                        System.out.println("잘못된 선택입니다. 추가 선택이 반영되지 않았습니다.");
                    }
                }
            }

            System.out.println("\n🔹 3단계: 음료를 선택하세요.");
            System.out.println("1) 콜라 : +0");
            System.out.println("2) 사이다 : +0");
            System.out.println("3) 오렌지 주스 : +500");
            System.out.println("4) 바닐라 쉐이크 : +500");
            System.out.println("5) 초코 쉐이크 : +500");
            System.out.print("선택: ");
            int drinkChoice = scanner.nextInt();
            order.setDrink(Drink.getDrink(drinkChoice));
            scanner.nextLine();
        }

        System.out.println("\n주문이 완료되었습니다! 결제하시겠습니까? (Y/N)");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("Y")) {
            order.checkout();
        } else {
            System.out.println("주문이 취소되었습니다.");
        }

        scanner.close();
    }
}