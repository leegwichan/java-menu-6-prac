package menu.controller;

import menu.domain.Coach;
import menu.domain.CoachInfo;
import menu.domain.ExceptMenu;
import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class ServiceManageController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RecommendService recommendService;
    private CoachInfo coachInfo;

    public ServiceManageController() {
        inputView = new InputView();
        outputView = new OutputView();
        recommendService = new RecommendService();
    }

    public void startRecommend() {
        outputView.introMessage();
        Coach coach = getCoachName();
        for(String coachName : coach.getCoachNames()) {
            coachInfo = getCoachInfo(coachName);
        }
        recommendService.recommendMenu(coachInfo);
        getRecommendResult(coachInfo);
    }

    private Coach getCoachName() {
        outputView.coachNameMessage();
        try {
            return new Coach(inputView.getInput());
        } catch (IllegalArgumentException exception) {
            outputView.errorMessage();
            return getCoachName();
        }
    }

    private ExceptMenu getExceptMenu(String coachName) {
        try {
            outputView.exceptMenuMessage(coachName);
            return new ExceptMenu(inputView.getInput());
        } catch (IllegalArgumentException exception) {
            outputView.errorMessage();
            return getExceptMenu(coachName);
        }
    }

    private CoachInfo getCoachInfo(String coachName) {
        ExceptMenu exceptMenu = getExceptMenu(coachName);
        List<String> exceptMenus = exceptMenu.getExceptMenus();
        coachInfo = setCoachInfo(coachName, exceptMenus);

        return coachInfo;
    }

    private CoachInfo setCoachInfo(String coachName, List<String> exceptMenus) {
        return new CoachInfo(coachName, exceptMenus);
    }

    private void getRecommendResult(CoachInfo coachInfo) {
        outputView.printRecommendCategory(recommendService.getRecommendedCategoryPerDay());
        for (String coachName : coachInfo.getCoachNames()) {
            outputView.printRecommendedFood(recommendService.getRecommendedMenus(coachName), coachName);
        }
    }
}
