package menu.exception;

public class InputError extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR] ";

    public InputError(String message) {
        super(PREFIX + message);
    }
}
