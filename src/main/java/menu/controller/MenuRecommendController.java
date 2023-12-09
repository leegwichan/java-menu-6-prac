package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.LunchRecommend;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printStartTitle();

        List<String> names = readRepeatedlyUntilNoException(this::readCoachNames);
        List<Coach> coaches = names.stream()
                .map(name -> readRepeatedlyUntilNoException(() -> readInedibleMenu(name)))
                .collect(Collectors.toList());

        LunchRecommend recommender = new LunchRecommend(coaches);
        outputView.printRecommendResult(recommender.generateRecommendResult());
    }

    private List<String> readCoachNames() {
        List<String> names = inputView.inputCoachNames();
        LunchRecommend.validateNames(names);
        return names;
    }

    private Coach readInedibleMenu(String name) {
        List<String> inedibleMenu = inputView.inputInedibleMenu(name);
        return new Coach(name, inedibleMenu);
    }

    private <T> T readRepeatedlyUntilNoException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return readRepeatedlyUntilNoException(supplier);
        }
    }
}
