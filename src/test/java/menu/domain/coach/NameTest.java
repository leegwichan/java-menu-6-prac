package menu.domain.coach;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {
    @DisplayName("코치의 이름이 2~4글자가 아니라면 예외가 발생해야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"포", "포비와크롱"})
    void validateLengthTest(String name) {
        // when, then
        assertThatThrownBy(() -> Name.from(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 코치의 이름은 2글자 ~ 4글자만 가능합니다.");
    }
}