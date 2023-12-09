package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private static final int MIN_NAME_SIZE = 2;
    private static final int MAX_NAME_SIZE = 4;
    private static final int MAX_INEDIBLE_MENU_COUNT = 2;

    private final String name;
    private final List<String> inedibleMenus;
    private final List<String> recommendedMenus = new ArrayList<>();

    public Coach(String name, List<String> inedibleMenus) {
        validateName(name);
        validateInedibleMenus(inedibleMenus);

        this.name = name;
        this.inedibleMenus = List.copyOf(inedibleMenus);
    }

    public static void validateName(String name) {
        if (isOutOfRange(name)) {
            String exceptionMessage = "이름은 %d글자 이상 %d글자 이하이어야 합니다".formatted(MIN_NAME_SIZE, MAX_NAME_SIZE);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private static boolean isOutOfRange(String name) {
        return name.length() < MIN_NAME_SIZE || name.length() > MIN_NAME_SIZE;
    }

    private static void validateInedibleMenus(List<String> inedibleMenus) {
        if (isOverThanMaxSize(inedibleMenus)) {
            String exceptionMessage = "못 먹는 음식은 %d개 이하이어야 합니다".formatted(MAX_INEDIBLE_MENU_COUNT);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private static boolean isOverThanMaxSize(List<String> inedibleMenus) {
        return inedibleMenus.size() > MAX_INEDIBLE_MENU_COUNT;
    }

    void addRecommendMenuBy(Category category) {
        String newMenu;
        do {
            newMenu = getRandomMenu(category);
        } while (isViolateRecommendCondition(newMenu));

        recommendedMenus.add(newMenu);
    }

    private String getRandomMenu(Category category) {
        return RandomMenuSelector.select(category.getMenus());
    }

    private boolean isViolateRecommendCondition(String newMenu) {
        return isInedible(newMenu) ||  isAlreadyRecommend(newMenu);
    }

    private boolean isInedible(String newMenu) {
        return inedibleMenus.contains(newMenu);
    }

    private boolean isAlreadyRecommend(String newMenu) {
        return recommendedMenus.contains(newMenu);
    }

    public void resetRecommendMenus() {
        recommendedMenus.clear();
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendedMenus() {
        return List.copyOf(recommendedMenus);
    }
}
