package menu.domain.coach;

import java.util.Objects;
import menu.exception.ErrorMessage;
import menu.exception.InputError;

public class Name {
    private static final int MIN_VALUE = 2;
    private static final int MAX_VALUE = 4;

    private final String name;

    private Name(String name) {
        validateLength(name);
        this.name = name;
    }

    public static Name from(String name) {
        return new Name(name);
    }

    public String get() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private void validateLength(String name) {
        if (isOutOfLength(name)) {
            throw new InputError(ErrorMessage.COACH_NAME_LENGTH);
        }
    }

    private boolean isOutOfLength(String name) {
        return name.length() < MIN_VALUE || name.length() > MAX_VALUE;
    }
}
