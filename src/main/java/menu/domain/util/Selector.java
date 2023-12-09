package menu.domain.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.MenuPerCategory;

import static menu.view.constant.Constant.*;

public class Selector {

    public MenuPerCategory pickCategory() {
        return MenuPerCategory.getCategory(Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE));
    }

    public String pickMenu(MenuPerCategory categoryMenu) {
        return Randoms.shuffle(MenuPerCategory.getMenus(categoryMenu)).get(MENU_SELECT_NUMBER);
    }
}
