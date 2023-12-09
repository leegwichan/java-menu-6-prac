package menu.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.List;
import menu.exception.InvalidInputException;

class MenuDataTest {

    @Test
    void 카테고리별_메뉴_목록_반환() {
        assertThat(MenuData.getMenusByCategory(Category.JAPANESE)).contains("규동", "우동");
        assertThat(MenuData.getMenusByCategory(Category.KOREAN)).contains("김밥", "김치찌개");
        assertThat(MenuData.getMenusByCategory(Category.CHINESE)).contains("깐풍기", "볶음면");
        assertThat(MenuData.getMenusByCategory(Category.ASIAN)).contains("팟타이", "카오 팟");
        assertThat(MenuData.getMenusByCategory(Category.WESTERN)).contains("라자냐", "그라탱");
    }

    @Test
    void 유효한_메뉴_검증() {
        assertThat(MenuData.getMenusByCategory(Category.JAPANESE)).contains("규동");
        MenuData.isValidMenu("규동");
    }

    @Test
    void 유효하지_않은_메뉴_검증_실패() {
        Throwable thrown = catchThrowable(() -> MenuData.isValidMenu("가상의 메뉴"));
        assertThat(thrown).isInstanceOf(InvalidInputException.class)
                .hasMessageContaining("잘못된 메뉴 입력입니다.");
    }
}
