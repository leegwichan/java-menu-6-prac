package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoachInfo {
    private final Map<String, List<String>> coachInfo;

    public CoachInfo(String coachName, List<String> exceptMenus) {
        this.coachInfo = getCoachInfo(coachName, exceptMenus);
    }

    private Map<String, List<String>> getCoachInfo(String coachName, List<String> exceptMenu) {
        Map<String, List<String>> coachInfo = new HashMap<>();
        coachInfo.put(coachName, exceptMenu);

        return coachInfo;
    }

    public List<String> getCoachNames() {
        return new ArrayList<>(coachInfo.keySet());
    }

    public boolean isForbiddenMenu(String coachName, String menu) {
        return coachInfo.get(coachName).contains(menu);
    }
}
