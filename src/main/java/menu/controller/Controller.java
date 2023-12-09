package menu.controller;

import java.util.List;
import menu.RandomNumberPicker;
import menu.domain.Recommendation;
import menu.domain.coach.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
    public void run() {
        OutputView.printInit();
        List<String> coachNames = InputView.getCoachNames();
        Coaches coaches = new Coaches(coachNames);
        coaches.getList().forEach(coach -> {
                    String name = coach.getName();
                    List<String> blockedMenus = InputView.getBlockedMenus(name);
                    coach.saveBlockedMenus(blockedMenus);
                }
        );

        Recommendation recommendation = new Recommendation(new RandomNumberPicker(), coaches);
        for (int i = 0; i < 5; i++) {
            recommendation.addCategory();
            recommendation.addRecommendMenu();
        }

        OutputView.printResult(recommendation.getCategories(), coaches.getRecommendedResultOfString());
        OutputView.printComplete();
    }
}
