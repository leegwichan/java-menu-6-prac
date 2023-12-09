package menu.domain;

import java.util.List;

public class LunchRecommend {

    private static final int MIN_COACHES = 2;
    private static final int MAX_COACHES = 5;

    private final List<Coach> coaches;

    public LunchRecommend(List<Coach> coaches) {
        validate(coaches);
        this.coaches = List.copyOf(coaches);
    }

    private void validate(List<Coach> coaches) {
        validateCountOfCoaches(coaches.size());
    }

    public static void validateNames(List<String> names) {
        validateCountOfCoaches(names.size());
        names.forEach(Coach::validateName);
    }

    private static void validateCountOfCoaches(int count) {
        if (isOutOfRange(count)) {
            String exceptionMessage = "코치는 최소 %d명 최대 %d명 이어야 합니다".formatted(MIN_COACHES, MAX_COACHES);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private static boolean isOutOfRange(int count) {
        return count < MIN_COACHES || count > MAX_COACHES;
    }
}
