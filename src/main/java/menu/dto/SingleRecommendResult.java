package menu.dto;

import java.util.List;
import menu.domain.Coach;

public class SingleRecommendResult {

    private final String name;
    private final List<String> recommendMenus;

    private SingleRecommendResult(String name, List<String> recommendMenus) {
        this.name = name;
        this.recommendMenus = recommendMenus;
    }

    public static SingleRecommendResult of(Coach coach) {
        return new SingleRecommendResult(coach.getName(), coach.getRecommendedMenus());
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendMenus() {
        return recommendMenus;
    }
}
