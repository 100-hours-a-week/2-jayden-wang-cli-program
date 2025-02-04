package food;

import java.util.List;

public class Side extends Item {
    public Side(String name, int price) {
        super(name, price);
    }

    public static final List<Side> SIDES = List.of(
            new Side("감자튀김 S", 0),
            new Side("감자튀김 L", 500)
    );

}
