package menu.domain.coach;

import java.util.List;

public class Coach {
    private final Name name;
    private BlockedMenus blockedMenus;
    private List<String> recommendedMenus;

    public Coach(String name, List<String> recommendedMenus) {
        this.name = Name.from(name);
        this.recommendedMenus = recommendedMenus;
    }

    public void saveBlockedMenus(List<String> menus) {
        this.blockedMenus = BlockedMenus.of(menus);
    }

    public void addRecommendedMenus(String menu) {
        this.recommendedMenus.add(menu);
    }

    public boolean isAllowedMenu(String menu) {
        return !isDuplicatedMenu(menu) || blockedMenus.isIn(menu);
    }

    private boolean isDuplicatedMenu(String menu) {
        return recommendedMenus.contains(menu);
    }
}
