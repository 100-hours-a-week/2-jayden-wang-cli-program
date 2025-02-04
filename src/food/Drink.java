package food;

import java.util.List;

public class Drink extends Item {
    public Drink (String name, int price) {
        super(name, price);
    }

    public static final List<Drink> DRINKS = List.of(
            new Drink("콜라", 0),
            new Drink("사이다", 0),
            new Drink("오렌지 주스", 500),
            new Drink("바닐라 쉐이크", 500),
            new Drink("초코 쉐이크", 500)
    );
}
