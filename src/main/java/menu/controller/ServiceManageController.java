package menu.controller;

import menu.domain.Coach;
import menu.domain.CoachInfo;
import menu.domain.ExceptMenu;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class ServiceManageController {

    private final InputView inputView;
    private final OutputView outputView;
    private CoachInfo coachInfo;

    public ServiceManageController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void startRecommend() {
        outputView.introMessage();
        Coach coach = getCoachName();
        for(String coachName : coach.getCoachNames()) {
            getCoachInfo(coachName);
        }
    }

    private void getCoachInfo(String coachName) {
        ExceptMenu exceptMenu = getExceptMenu(coachName);
        List<String> exceptMenus = exceptMenu.getExceptMenus();
        coachInfo = setCoachInfo(coachName, exceptMenus);
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

    private CoachInfo setCoachInfo(String coachName, List<String> exceptMenus) {
        return new CoachInfo(coachName, exceptMenus);
    }
}
