package menu.domain;

import menu.domain.util.Conversion;
import menu.domain.util.Verification;

import java.util.List;

public class Coach {

    private final List<String> coachNames;
    private final Verification verification;
    private final Conversion conversion;

    public Coach(String coachNames) {
        verification = new Verification();
        conversion = new Conversion();
        verification.verificationAll(coachNames);
        this.coachNames = conversion.convertToList(coachNames);
    }

    public int size() {
        return coachNames.size();
    }

    public List<String> getCoachNames() {
        return coachNames;
    }
}
