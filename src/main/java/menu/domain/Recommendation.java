package menu.domain;

import java.util.List;
import menu.NumberPicker;

public class Recommendation {
    private static final int LIMIT_SAME_CATEGORY = 2;

    private final NumberPicker numberPicker;
    private List<Catogory> categories;

    public Recommendation(NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    public void addCategory() {
        while (true) {
            Catogory selectedCatogory = selectCategory();
            if (isLimitAllowed(selectedCatogory)) {
                categories.add(selectedCatogory);
                return;
            }
        }
    }

    private Catogory selectCategory() {
        return Menu.getCategories().get(numberPicker.pick() - 1);
    }

    private boolean isLimitAllowed(Catogory selectedCatogory) {
        return categories.stream()
                .filter(catogory -> catogory.equals(selectedCatogory))
                .count() < LIMIT_SAME_CATEGORY;
    }

}
