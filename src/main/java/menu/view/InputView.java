package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private static final String INPUT_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_BLOCKED_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String DELIMITER = ",";

    public static List<String> getCoachNames() {
        print(INPUT_NAME);
        return split(read());
    }

    public static List<String> getBlockedMenus(String name) {
        print(String.format(INPUT_BLOCKED_MENU, name));
        return split(read());
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static String read() {
        return Console.readLine().trim();
    }

    private static List<String> split(String data) {
        return List.of(data.split(DELIMITER));
    }
}
