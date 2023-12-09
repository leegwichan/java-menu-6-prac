package menu.controller;

import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class ServiceManageController {

    private final InputView inputView;
    private final OutputView outputView;

    public ServiceManageController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void startRecommend() {
        outputView.introMessage();
        getCoachName();
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
}
