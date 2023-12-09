package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import menu.dto.MultiRecommendResult;
import menu.dto.SingleRecommendResult;

public class OutputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String FINISH_MESSAGE = "추천을 완료했습니다.";

    private static final String PREFIX_DAY_OF_WEEK = "구분";
    private static final List<String> DAY_OF_WEEK = List.of("월요일", "화요일", "수요일", "목요일", "금요일");
    private static final String PREFIX_CATEGORY = "카테고리";

    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printStartTitle() {
        println(START_MESSAGE);
    }

    public void printRecommendResult(MultiRecommendResult results) {
        println(RESULT_MESSAGE);

        printByTableRowFormat(PREFIX_DAY_OF_WEEK, DAY_OF_WEEK);
        printByTableRowFormat(PREFIX_CATEGORY, results.getCategories());
        results.getResults().forEach(this::printByTableRowFormat);

        printBlankLine();
        println(FINISH_MESSAGE);
    }

    private void printByTableRowFormat(SingleRecommendResult result) {
        printByTableRowFormat(result.getName(), result.getRecommendMenus());
    }

    private void printByTableRowFormat(String prefix, List<String> contents) {
        String message = Stream.concat(Stream.of(prefix), contents.stream())
                .collect(Collectors.joining(" | ", "[ ", " }"));
        println(message);
    }

    public void printErrorMessage(Exception exception) {
        println(ERROR_PREFIX.concat(exception.getMessage()));
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void printBlankLine() {
        System.out.println();
    }
}
