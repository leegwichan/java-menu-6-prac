package menu.domain;

import menu.domain.util.Conversion;
import menu.domain.util.Verification;

import java.util.List;

public class ExceptMenu {
    private final List<String> exceptMenus;
    private final Verification verification;
    private final Conversion conversion;

    public ExceptMenu(String exceptMenu) {
        verification = new Verification();
        conversion = new Conversion();

        verification.checkInputFormat(exceptMenu);
        this.exceptMenus = conversion.convertToList(exceptMenu);
    }

    public List<String> getExceptMenus() {
        return exceptMenus;
    }
}
