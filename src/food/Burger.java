package food;

import java.util.List;

public class Burger extends Item {
    public Burger(String name, int price) {
        super(name, price);
    }

    public static final List<Burger> BURGERS = List.of(
            new Burger("치즈버거", 3000),
            new Burger("불고기버거", 3500),
            new Burger("빅맥", 5000),
            new Burger("1955버거", 6000),
            new Burger("베이컨 토마토 디럭스 버거", 7000)
    );
}
