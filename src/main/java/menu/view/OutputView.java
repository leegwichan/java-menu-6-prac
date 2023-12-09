package menu.view;

public class OutputView {
    private static final String START_RECOMMENDATION = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT = "메뉴 추천 결과입니다.";
    private static final String DONE = "추천을 완료했습니다.";

    public static void printInit() {
        print(START_RECOMMENDATION);
    }

    public static void printResult() {
        print(RESULT);
    }

    public static void printComplete() {
        print(DONE);
    }


    private static void print(String message) {
        System.out.println(message);
    }
}
