package menu.view;

public class OutputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    public void printStartTitle() {
        println(START_MESSAGE);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
