package food;

public class Drink extends Item {
    public Drink (String name, int price) {
        super(name, price);
    }

    public static Drink getDrink(int choice) {
        switch (choice) {
            case 1: return new Drink("콜라", 0);
            case 2: return new Drink("사이다", 0);
            case 3: return new Drink("오렌지 주스", 500);
            case 4: return new Drink("바닐라 쉐이크", 500);
            case 5: return new Drink("초코 쉐이크", 500);
        }
        return null;
    }
}
