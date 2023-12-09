package menu.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static menu.view.constant.Constant.MAX_CATEGORY_COUNT;

public class RecommendCategory {
    private final EnumMap<MenuPerCategory, Integer> categoryHistory = new EnumMap<>(MenuPerCategory.class);
    private final List<MenuPerCategory> dayRecommendedCategoryInfo = new ArrayList<>();

    public boolean isPossibleCategory(MenuPerCategory menuPerCategory) {
        Integer mealCount = categoryHistory.getOrDefault(menuPerCategory, 0);
        return mealCount < MAX_CATEGORY_COUNT;
    }

    public void mealCategory(MenuPerCategory menuPerCategory) {
        categoryHistory.put(menuPerCategory, categoryHistory.getOrDefault(menuPerCategory, 0) + 1);
    }

    public void saveCategoryInfoPerDay(MenuPerCategory menuPerCategory) {
        dayRecommendedCategoryInfo.add(menuPerCategory);
    }

    public List<MenuPerCategory> getCategoryRecommendedInfo() {
        return new ArrayList<>(dayRecommendedCategoryInfo);
    }
}
