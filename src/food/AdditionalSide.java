package food;

import java.util.List;

public class AdditionalSide extends Side{
    private String category;

    public AdditionalSide(String name, int price, String category) {
        super(name, price);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public static final List<String> CATEGORIES = List.of("토핑", "소스", "맥플러리");

    public static final List<AdditionalSide> Topping = List.of(
            new AdditionalSide("치즈 토핑", 500, "토핑"),
            new AdditionalSide("베이컨 토핑", 700, "토핑"),
            new AdditionalSide("아보카도 토핑", 800, "토핑")
    );

    public static final List<AdditionalSide> Sauce = List.of(
            new AdditionalSide("치즈 소스", 500, "소스"),
            new AdditionalSide("BBQ 소스", 400, "소스"),
            new AdditionalSide("갈릭 소스", 400, "소스"),
            new AdditionalSide("스위트 칠리 소스", 400, "소스")
    );

    public static final List<AdditionalSide> McFlurry = List.of(
            new AdditionalSide("오레오 맥플러리", 2000, "맥플러리"),
            new AdditionalSide("딸기 맥플러리", 2100, "맥플러리"),
            new AdditionalSide("초코 맥플러리", 2500, "맥플러리")
    );

    public static List<AdditionalSide> getAdditionalSideByCatecory(String category) {
        switch (category) {
            case "토핑": return Topping;
            case "소스": return Sauce;
            case "맥플러리": return McFlurry;
        }
        return null;
    }
}
