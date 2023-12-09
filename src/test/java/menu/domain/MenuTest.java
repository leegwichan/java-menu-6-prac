package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class MenuTest {
    @DisplayName("카테고리 목록을 정해진 순서대로 가져와야 한다")
    @ParameterizedTest
    @CsvSource(value = {"1:일식", "2:한식", "3:중식", "4:아시안", "5:양식"}, delimiter = ':')
    void getCategoriesTest(int number, String category) {
        // given
        int index = number - 1;

        // when
        List<Category> categories = Menu.getCategories();

        // then
        assertThat(categories.get(index).toString()).isEqualTo(category);
    }

    @DisplayName("특정 카테고리의 음식 리스트를 가져와야 한다")
    @ParameterizedTest
    @MethodSource("getMenuListByCategory")
    void getFoodsByCategoryTest(MenuDto menu) {
        // given
        Category category = menu.getCategory();
        List<String> menus = menu.getMenus();

        // when
        List<String> foods = Menu.getFoodsByCategory(category);

        // then
        assertThat(foods).containsAll(menus);
    }

    static Stream<MenuDto> getMenuListByCategory() {
        return Stream.of(
                new MenuDto(Category.일식, List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
                new MenuDto(Category.한식, List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
                new MenuDto(Category.중식, List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
                new MenuDto(Category.아시안, List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
                new MenuDto(Category.양식, List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"))
        );
    }
}

class MenuDto {
    private final Category category;
    private final List<String> menus;

    public MenuDto(Category category, List<String> menus) {
        this.category = category;
        this.menus = menus;
    }

    public Category getCategory() {
        return category;
    }

    public List<String> getMenus() {
        return menus;
    }
}
