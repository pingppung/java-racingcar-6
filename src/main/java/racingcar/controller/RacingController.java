package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RacingGameInfo;
import racingcar.view.InputView;

public class RacingController {
    private final InputView inputView;

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void startRace() {
        List<String> carNames = inputView.getCarNames();
        int tryCount = inputView.getTryCount();
        RacingGameInfo racingGameInfo = new RacingGameInfo(carNames, tryCount);
        Cars cars = new Cars(racingGameInfo);


    }
}
