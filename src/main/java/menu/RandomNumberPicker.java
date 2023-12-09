package menu;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberPicker implements NumberPicker {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 5;

    @Override
    public int pick() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }
}
