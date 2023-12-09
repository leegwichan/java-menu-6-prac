package menu.domain.coach;

import java.util.HashSet;
import java.util.List;
import menu.exception.ErrorMessage;
import menu.exception.InputError;

public class BlockedMenus {
    private static final int MAX_VALUE = 2;

    private final List<String> menus;

    private BlockedMenus(List<String> menus) {
        validateSize(menus);
        validateDuplicate(menus);
        this.menus = menus;
    }

    public static BlockedMenus of(List<String> menus) {
        return new BlockedMenus(menus);
    }

    public boolean isIn(String menu) {
        return menus.contains(menu);
    }

    private void validateSize(List<String> menus) {
        if (menus.size() > MAX_VALUE) {
            throw new InputError(ErrorMessage.MENU_SIZE);
        }
    }

    private void validateDuplicate(List<String> menus) {
        if (menus.size() != new HashSet<>(menus).size()) {
            throw new InputError(ErrorMessage.DUPLICATED);
        }
    }
}
