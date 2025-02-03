package food;

public class Side extends Item {
    public Side(String name, int price) {
        super(name, price);
    }

    public static Side getSide(int choice) {
        switch (choice) {
            case 1: return new Side("감자튀김 S", 0);
            case 2: return new Side("감자튀김 L", 500);
        }
        return null;
    }
}
