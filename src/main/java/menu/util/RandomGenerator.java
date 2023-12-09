package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomGenerator implements Generatable {
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(1, 5);
    }

    @Override
    public String getElementOf(List<String> values) {
        return Randoms.shuffle(values).get(0);
    }
}
