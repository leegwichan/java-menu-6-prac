package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomMenuSelector {

    private RandomMenuSelector() {
    }

    public static String select(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
