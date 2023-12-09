package menu.service;

import menu.domain.RecommendMenu;
import menu.domain.MenuPerCategory;
import menu.domain.CoachInfo;
import menu.domain.RecommendCategory;
import menu.domain.util.Selector;

import java.util.List;
import static menu.view.constant.Constant.DAY_COUNT;

public class RecommendService {

    private final RecommendCategory recommendCategory;
    private final RecommendMenu recommendMenu;
    private final Selector selector;

    public RecommendService() {
        recommendCategory = new RecommendCategory();
        recommendMenu = new RecommendMenu();
        selector = new Selector();
    }

    public void recommendMenu(CoachInfo coachInfo) {
        int oneWeek = DAY_COUNT;
        while (oneWeek-- > 0) {
            MenuPerCategory category = pickPossibleCategory();
            for (String coachName : coachInfo.getCoachNames()) {
                String menu = pickPossibleMenu(category, coachName, coachInfo);
                recommendMenu.recommendMenu(coachName, menu);
            }
            recommendCategory.saveCategoryInfoPerDay(category);
        }
    }

    public List<MenuPerCategory> getRecommendedCategoryPerDay() {
        return recommendCategory.getCategoryRecommendedInfo();
    }

    public List<String> getRecommendedMenus(String coachName) {
        return recommendMenu.getRecommendedMenuPerCoach(coachName);
    }

    private MenuPerCategory pickPossibleCategory() {
        MenuPerCategory category = findPossibleCategory();
        if (recommendCategory.isPossibleCategory(category)) {
            return category;
        }
        return pickPossibleCategory();
    }

    private MenuPerCategory findPossibleCategory() {
        MenuPerCategory category = selector.pickCategory();
        if (recommendCategory.isPossibleCategory(category)) {
            return category;
        }
        return findPossibleCategory();
    }

    private String pickPossibleMenu(MenuPerCategory category, String coachName, CoachInfo coachInfo) {
        String menu = selector.pickMenu(category);
        if (recommendMenu.isPossibleMenu(coachName, menu) && !coachInfo.isForbiddenMenu(coachName,menu)) {
            return menu;
        }
        return pickPossibleMenu(category, coachName, coachInfo);
    }
}
