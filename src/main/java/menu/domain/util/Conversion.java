package menu.domain.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Conversion {
    public String[] convertToArray(String coachNames) {
        return coachNames.split(",");
    }

    public List<String> convertToList(String coachNames) {
        String[] names = convertToArray(coachNames);
        List<String> convertedNames = new ArrayList<>();

        Collections.addAll(convertedNames, names);
        return convertedNames;
    }
}
