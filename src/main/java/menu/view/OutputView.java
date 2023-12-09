package menu.view;

import static menu.view.constant.OutputConstant.ERROR_MESSAGE;

public class OutputView {
    public void introMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public void coachNameMessage() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void errorMessage() {
        System.out.println(ERROR_MESSAGE);
    }
}
