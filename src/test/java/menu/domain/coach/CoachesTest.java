package menu.domain.coach;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachesTest {
    @DisplayName("코치가 2명 미만, 5명 초과 입력되었을 경우 예외가 발생해야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"토미", "토미,제임스,포코,포비,크롱,호눅스"})
    void validateSizeTest(String names) {
        // given
        List<String> coachNames = List.of(names.split(","));

        // when, then
        assertThatThrownBy(() -> new Coaches(coachNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 코치는 2명 ~ 5명만 입력 가능합니다.");
    }

    @DisplayName("코치 이름이 중복 입력되었을 경우 예외가 발생해야 한다")
    @Test
    void validateDuplicateTest() {
        // given
        List<String> coachNames = List.of("포비", "제임스", "포비");

        // when, then
        assertThatThrownBy(() -> new Coaches(coachNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 값의 입력은 불가능합니다.");
    }
}