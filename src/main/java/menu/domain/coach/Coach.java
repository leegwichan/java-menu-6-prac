package menu.domain.coach;

import java.util.List;

public class Coach {
    private final Name name;
    private BlockedMenus blockedMenus;

    public Coach(String name) {
        this.name = Name.from(name);
    }

    public void saveBlockedMenus(List<String> menus) {
        this.blockedMenus = BlockedMenus.of(menus);
    }
}
