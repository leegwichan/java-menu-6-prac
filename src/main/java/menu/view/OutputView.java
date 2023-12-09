package menu.view;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import menu.domain.Category;

public class OutputView {
    private static final String START_RECOMMENDATION = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT = "메뉴 추천 결과입니다.";
    private static final String DONE = "추천을 완료했습니다.";

    public static void printInit() {
        print(START_RECOMMENDATION);
    }

    public static void printResult(List<Category> categories, String recommendedResultOfString) {
        print(RESULT);
        print("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        print("[ 카테고리 | " + categories.stream().map(Objects::toString).collect(Collectors.joining(" | ")) + " ]");
        print(recommendedResultOfString);
    }

    public static void printComplete() {
        print(DONE);
    }


    private static void print(String message) {
        System.out.println(message);
    }
}
