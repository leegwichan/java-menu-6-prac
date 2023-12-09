package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class RandomCategoryGenerator {

    private static final int RANDOM_MIN_NUMBER = 1;
    private static final int RANDOM_MAX_NUMBER = 5;
    private static final Map<Integer, Category> RANDOM_NUMBER_TO_CATEGORY
            = Map.of(1, Category.JAPANESE, 2, Category.KOREAN, 3, Category.CHINESE, 4,
            Category.ASIAN, 5, Category.WESTERN);

    private RandomCategoryGenerator() {
    }

    public static Category generate() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
        return RANDOM_NUMBER_TO_CATEGORY.get(randomNumber);
    }
}
