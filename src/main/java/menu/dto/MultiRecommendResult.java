package menu.dto;

import java.util.List;
import menu.domain.Category;

public class MultiRecommendResult {

    private final List<Category> categories;
    private final List<SingleRecommendResult> results;

    public MultiRecommendResult(List<Category> categories, List<SingleRecommendResult> results) {
        this.categories = categories;
        this.results = results;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<SingleRecommendResult> getResults() {
        return results;
    }
}
