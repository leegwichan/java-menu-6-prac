package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CoachTest {
    @DisplayName("입력 형식이 잘못된 경우에 대한 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"토미,,", "!제임스", "포코..."})
    void playerNumberLengthOut(String input) {
        assertThatThrownBy(() -> new Coach(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치의 이름이 최소 2글자, 최대 4글자가 아닌 경우에 대한 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"톰", "크리스티나"})
    void playerNumberRangeOut(String input) {
        assertThatThrownBy(() -> new Coach(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치의 수가 최소 2명, 최대 5명이 아닌 경우에 대한 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"토미", "제임스", "포코", "크리스", "제니", "줄리아"})
    void playerNumberDuplicate(String input) {
        assertThatThrownBy(() -> new Coach(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}