package food;

public class Burger extends Item {
    public Burger(String name, int price) {
        super(name, price);
    }

    public static Burger getBurger(int choice) {
        switch (choice) {
            case 1: return new Burger("치즈버거", 3000);
            case 2: return new Burger("불고기버거", 3500);
            case 3: return new Burger("빅맥", 5000);
            case 4: return new Burger("1955버거", 6000);
            case 5: return new Burger("베이컨 토마토 디럭스 버거", 7000);
        }
        return null;
    }
}
