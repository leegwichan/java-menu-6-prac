package menu.service;

import java.util.Collections;
import java.util.List;
import menu.model.MenuData;

public class Menus {
    private final List<String> menuList;

    public Menus (List<String> menuList) {
        validateMenuList(menuList);
        this.menuList= menuList;
    }

    private void validateMenuList(List<String> menuList) {
        menuList.forEach(MenuData::isValidMenu);
    }

    public List<String> getMenuList() {
        return Collections.unmodifiableList(menuList);
    }
}
