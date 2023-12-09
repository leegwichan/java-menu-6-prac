package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MenuTest {
    @DisplayName("카테고리 목록을 정해진 순서대로 가져와야 한다")
    @ParameterizedTest
    @CsvSource(value = {"1:일식", "2:한식", "3:중식", "4:아시안", "5:양식"}, delimiter = ':')
    void getCategoriesTest(int number, String category) {
        // given
        int index = number - 1;

        // when
        List<String> categories = Menu.getCategories();

        // then
        assertThat(categories.get(index)).isEqualTo(category);
    }
}