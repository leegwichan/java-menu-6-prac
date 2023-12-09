package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String REQUEST_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";

    private static final String STRING_DELIMITER = ",";
    private static final int DELIMITER_LIMIT = -1;

    public List<String> inputCoachNames() {
        printRequestMessage(REQUEST_COACH_NAMES);
        return readStrings();
    }

    private List<String> readStrings() {
        return Arrays.stream(read().split(STRING_DELIMITER, DELIMITER_LIMIT))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void printRequestMessage(String message) {
        System.out.println();
        System.out.println(message);
    }

    private String read() {
        return Console.readLine();
    }
}
