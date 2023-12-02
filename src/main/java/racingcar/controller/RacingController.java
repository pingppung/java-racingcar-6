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
        RacingGameInfo racingGameInfo = getRacingGameInfoFromInput();
        Cars cars = createCarsForRace(racingGameInfo);
        cars.tryMovingCars();
    }

    private RacingGameInfo getRacingGameInfoFromInput() {
        List<String> carNames = inputView.getCarNames();
        int tryCount = inputView.getTryCount();
        return new RacingGameInfo(carNames, tryCount);
    }

    private Cars createCarsForRace(RacingGameInfo racingGameInfo) {
        return new Cars(racingGameInfo);
    }

    private void moveCars(Cars cars) {
        cars.tryMovingCars();
    }

    private void displayResults(Cars cars) {
        cars.getCars();
    }
}
