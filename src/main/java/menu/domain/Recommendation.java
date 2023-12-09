package menu.domain;

import java.util.List;
import menu.NumberPicker;

public class Recommendation {
    private static final int LIMIT_SAME_CATEGORY = 2;

    private final NumberPicker numberPicker;
    private List<Category> categories;

    public Recommendation(NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
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

    private Category selectCategory() {
        return Menu.getCategories().get(numberPicker.pick() - 1);
    }

    private boolean isLimitAllowed(Category selectedCategory) {
        return categories.stream()
                .filter(category -> category.equals(selectedCategory))
                .count() < LIMIT_SAME_CATEGORY;
    }

}
