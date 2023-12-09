package menu.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.model.Category;
import menu.model.MenuData;
import menu.util.Generatable;

public class MenuSelector {
    private final Generatable generator;

    public MenuSelector(Generatable generator) {
        this.generator = generator;
    }

    /**
     * 같은 메뉴가 없고
     * 못먹는 음식이 없는 Menus 반환
     * @param coaches 코치들
     * @param categories 날짜별 카테고리
     * @return 선택된 메뉴 맵 반환
     */
    public Map<Coach, Menus> getSelectedMenus(Coaches coaches, List<Category> categories) {
        Map<Coach, Menus> selectedMenus = new LinkedHashMap<>();
        for(Coach coach: coaches.getCoachList()) {
            selectedMenus.put(coach, selectMenuByCoach(coach, categories));
        }

        return selectedMenus;
    }

    private Menus selectMenuByCoach(Coach coach, List<Category> categories) {
        List<String> menus = new ArrayList<>();
        for (Category category: categories) {
            String menu = generator.getRandomElementOf(MenuData.getMenusByCategory(category));
            if (isInValidMenuForCoach(coach, menus, menu)) {
                continue;
            }
            menus.add(menu);
        }
        return new Menus(menus);
    }

    private boolean isInValidMenuForCoach(Coach coach, List<String> menus, String menu) {
        return menus.contains(menu) || coach.isBannedMenu(menu);
    }
}
