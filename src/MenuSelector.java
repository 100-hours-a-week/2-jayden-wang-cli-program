import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class MenuSelector {
    private final Scanner scanner;

    public MenuSelector(Scanner scanner) {
        this.scanner = scanner;
    }

    public <T> T selectMenuItem(String prompt,
                                List<T> items,
                                Function<T, String> nameExtractor,
                                Function<T, Integer> priceExtractor)
    {
        while (true) {
            try {
                System.out.println("\n" + prompt);
                System.out.println("0)주문 취소");

                for (int i = 0; i < items.size(); i++) {
                    T item = items.get(i);
                    System.out.println((i + 1) + ")" + nameExtractor.apply(item) + " : " + priceExtractor.apply(item));
                }

                System.out.print("선택: ");
                int choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("\n주문이 취소되었습니다.");
                    System.exit(0);
                }

                if (choice >= 1 && choice <= items.size()) {
                    scanner.nextLine();
                    return items.get(choice - 1);
                }

                System.out.println("\n ❌ 메뉴에 있는 번호를 선택해주세요.");
            } catch (InputMismatchException e) {
                System.out.println("\n ❌ 숫자를 입력해주세요.");
                scanner.nextLine();
            }
        }
    }

    public boolean selectYesNo(String prompt) {
        while (true) {
            System.out.println("\n" + prompt + " (Y/N)");

            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")) {
                return choice.equalsIgnoreCase("Y");
            }

            System.out.println("\n ❌ Y 또는 N을 입력해주세요.");
        }
    }
}