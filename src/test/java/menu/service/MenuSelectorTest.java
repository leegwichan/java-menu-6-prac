package menu.service;

import menu.util.RandomGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import menu.model.Category;
import menu.service.Menus;
import menu.util.FakeGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MenuSelectorTest {

    @RepeatedTest(100)
    void 선택된_메뉴_검증() {
        // FakeGenerator 설정: 항상 첫 번째 메뉴를 선택하도록 설정
        MenuSelector menuSelector = new MenuSelector(new RandomGenerator());

        // 코치 및 카테고리 목록 설정
        List<String> bannedMenusForCoach1 = Arrays.asList("규동", "우동");
        List<String> bannedMenusForCoach2 = Arrays.asList("김치찌개", "불고기");
        Coach coach1 = new Coach("코치1", new Menus(bannedMenusForCoach1));
        Coach coach2 = new Coach("코치2", new Menus(bannedMenusForCoach2)); // 금지된 메뉴 포함
        Coaches coaches = new Coaches(Arrays.asList(coach1, coach2));
        List<Category> categories = Arrays.asList(Category.JAPANESE, Category.KOREAN);

        // 선택된 메뉴 검증
        Map<Coach, Menus> selectedMenus = menuSelector.getSelectedMenus(coaches, categories);
        Menus menus1 = selectedMenus.get(coach1);
        for (String s: bannedMenusForCoach1) {
            assertThat(menus1.hasMenu(s)).isFalse();
        }

        Menus menus2 = selectedMenus.get(coach2);
        for (String s: bannedMenusForCoach2) {
            assertThat(menus2.hasMenu(s)).isFalse();
        }
    }
}
