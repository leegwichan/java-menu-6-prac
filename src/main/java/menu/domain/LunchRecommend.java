package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.dto.MultiRecommendResult;

public class LunchRecommend {

    private static final int MIN_COACHES = 2;
    private static final int MAX_COACHES = 5;
    private static final int COUNT_OF_RECOMMEND_MENU = 5;
    private static final int MAX_COUNT_OF_OVERLAPPED_CATEGORY = 2;

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

    public MultiRecommendResult generateRecommendResult() {
        coaches.forEach(Coach::resetRecommendMenus);

        List<Category> categories = new ArrayList<>();
        for (int index = 0; index < COUNT_OF_RECOMMEND_MENU; index++) {
            addValidateCategory(categories);
            Category newCategory = categories.get(index);
            coaches.forEach(coach -> coach.addRecommendMenuBy(newCategory));
        }

        return MultiRecommendResult.of(categories, coaches);
    }

    private void addValidateCategory(List<Category> categories) {
        Category newCategory;
        do {
            newCategory = RandomCategoryGenerator.generate();
        } while (isViolateRecommendRule(categories, newCategory));

        categories.add(newCategory);
    }

    private boolean isViolateRecommendRule(List<Category> categories, Category newCategory) {
        return categories.stream()
                .filter(category -> category == newCategory)
                .count() > MAX_COUNT_OF_OVERLAPPED_CATEGORY;

    }
}
