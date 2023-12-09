package menu.domain;

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
}
