package menu.domain.util;

public class Verification {
    private final String regex = "^[ㄱ-ㅎ가-힣]*$";
    private Conversion conversion;

    public void verificationAll(String coachNames) {
        conversion = new Conversion();
        checkInputFormat(coachNames);
        checkNameLength(coachNames);
        checkCoachCount(coachNames);
    }

    private void checkInputFormat(String coachNames) {
        String[] names = conversion.convertToArray(coachNames);

        for (String name : names) {
            if (!(name.matches(regex))) {
                throw new IllegalArgumentException("[ERROR] 이름은 최소 2글자, 최대 4글자로 입력해주세요.");
            }
        }
    }

    private void checkNameLength(String coachNames) {
        String[] names = conversion.convertToArray(coachNames);

        for (String name : names) {
            if (!(name.length() >= 2 && name.length() <= 4)) {
                throw new IllegalArgumentException("[ERROR] 이름은 최소 2글자, 최대 4글자로 입력해주세요.");
            }
        }
    }

    public void checkCoachCount(String coachNames) {
        String[] names = conversion.convertToArray(coachNames);

        if(!(names.length >= 2 && names.length <= 5)) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명까지만 가능합니다.");
        }
    }
}