package menu.domain.coach;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import menu.exception.ErrorMessage;
import menu.exception.InputError;

public class Coaches {
    private static final int MIN_VALUE = 2;
    private static final int MAX_VALUE = 5;

    private final List<Coach> coaches;

    public Coaches(List<String> names) {
        validateSize(names);
        validateDuplicate(names);
        this.coaches = generateCoachesByNames(names);
    }
    
    public List<Coach> getList() {
        return Collections.unmodifiableList(coaches);
    }

    private void validateSize(List<String> names) {
        if (isOutOfSize(names)) {
            throw new InputError(ErrorMessage.COACH_SIZE);
        }
    }

    private boolean isOutOfSize(List<String> names) {
        return names.size() < MIN_VALUE || names.size() > MAX_VALUE;
    }

    private void validateDuplicate(List<String> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new InputError(ErrorMessage.DUPLICATED);
        }
    }

    private static List<Coach> generateCoachesByNames(List<String> names) {
        return names.stream()
                .map(Coach::new)
                .collect(Collectors.toList());
    }
}
