package menu.domain.coach;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlockedMenusTest {
    @DisplayName("못 먹는 메뉴를 3개 이상 입력했으면 예외가 발생해야 한다")
    @Test
    void validateSizeTest() {
        // given
        List<String> blockedMenus = List.of("된장찌개", "비빔밥", "가츠동");

        // when, then
        assertThatThrownBy(() -> BlockedMenus.of(blockedMenus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 못 먹는 메뉴는 0개 ~ 2개만 입력 가능합니다.");
    }

    @DisplayName("못 먹는 메뉴를 중복 입력했으면 예외가 발생해야 한다.")
    @Test
    void validateDuplicateTest() {
        // given
        List<String> blockedMenus = List.of("불고기", "불고기");

        // when, then
        assertThatThrownBy(() -> BlockedMenus.of(blockedMenus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 값의 입력은 불가능합니다.");
    }
}