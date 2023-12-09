package menu.exception;

public class ErrorMessage {
    public static final String NOT_FOUND_CATEGORY = "해당하는 카테고리가 존재하지 않습니다.";
    public static final String COACH_NAME_LENGTH = "코치의 이름은 2글자 ~ 4글자만 가능합니다.";
    public static final String COACH_SIZE = "코치는 2명 ~ 5명만 입력 가능합니다.";
    public static final String MENU_SIZE = "못 먹는 메뉴는 0개 ~ 2개만 입력 가능합니다.";
    public static final String DUPLICATED = "중복된 값의 입력은 불가능합니다.";

    private ErrorMessage() {
    }
}
