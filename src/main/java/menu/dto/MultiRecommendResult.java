package menu.dto;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;

public class MultiRecommendResult {

    private final List<Category> categories;
    private final List<SingleRecommendResult> results;

    private MultiRecommendResult(List<Category> categories, List<SingleRecommendResult> results) {
        this.categories = categories;
        this.results = results;
    }

    public static MultiRecommendResult of(List<Category> categories, List<Coach> coaches) {
        List<SingleRecommendResult> results = coaches.stream()
                .map(SingleRecommendResult::of)
                .collect(Collectors.toList());

        return new MultiRecommendResult(categories, results);
    }

    public List<String> getCategories() {
        return categories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }

    public List<SingleRecommendResult> getResults() {
        return results;
    }
}
