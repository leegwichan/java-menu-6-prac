package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.NumberPicker;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;

public class Recommendation {
    private static final int LIMIT_SAME_CATEGORY = 2;

    private final NumberPicker numberPicker;
    private List<Category> categories;
    private Coaches coaches;

    public Recommendation(NumberPicker numberPicker, Coaches coaches) {
        this.numberPicker = numberPicker;
        this.categories = new ArrayList<>();
        this.coaches = coaches;
    }

    public void addCategory() {
        while (true) {
            Category selectedCategory = selectCategory();
            if (isLimitAllowed(selectedCategory)) {
                categories.add(selectedCategory);
                return;
            }
        }
    }

    public void addRecommendMenu() {
        coaches.getList().forEach(this::saveMenu);
    }

    public List<Category> getCategories() {
        return Collections.unmodifiableList(categories);
    }

    private String selectMenuByLastCategory() {
        Category category = categories.get(categories.size() - 1);
        List<String> foods = Menu.getFoodsByCategory(category);
        return Randoms.shuffle(foods).get(0);
    }

    private Category selectCategory() {
        return Menu.getCategories().get(numberPicker.pick() - 1);
    }

    private boolean isLimitAllowed(Category selectedCategory) {
        return categories.stream()
                .filter(category -> category.equals(selectedCategory))
                .count() < LIMIT_SAME_CATEGORY;
    }

    private void saveMenu(Coach coach) {
        while (true) {
            String menu = selectMenuByLastCategory();
            if (coach.isAllowedMenu(menu)) {
                coach.addRecommendedMenus(menu);
                return;
            }
        }
    }
}
