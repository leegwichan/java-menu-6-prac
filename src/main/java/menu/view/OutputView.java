package menu.view;


import menu.domain.Day;
import menu.domain.MenuPerCategory;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    public static final String ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다. 다시 입력해주세요.";

    public void introMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void coachNameMessage() {
        System.out.println("\n코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void exceptMenuMessage(String coachName) {
        System.out.println("\n" + coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public void printRecommendCategory(List<MenuPerCategory> categoryMealHistory) {
        makeDayMessage();
        makeCategoryMessage(categoryMealHistory);
    }

    public void printRecommendedFood(List<String> menus, String coachName) {
        StringJoiner messageFormat = new StringJoiner(" | ", "[ ", " ]");
        messageFormat.add(coachName);
        for (String menu : menus) {
            messageFormat.add(menu);
        }
        System.out.println(messageFormat);
    }

    private void makeDayMessage() {
        StringJoiner messageFormat = new StringJoiner(" | ", "[ ", " ]");
        messageFormat.add("구분");
        for (Day day : Day.values()) {
            messageFormat.add(day.getDay());
        }
        System.out.println("\n" + messageFormat);
    }

    private void makeCategoryMessage(List<MenuPerCategory> categoryMealHistory) {
        StringJoiner messageFormat = new StringJoiner(" | ", "[ ", " ]");
        messageFormat.add("카테고리");
        for (MenuPerCategory categoryMenu : categoryMealHistory) {
            messageFormat.add(categoryMenu.getCategoryName());
        }
        System.out.println(messageFormat);
    }

    public void errorMessage() {
        System.out.println(ERROR_MESSAGE);
    }
}
