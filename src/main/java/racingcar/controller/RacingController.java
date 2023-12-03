package racingcar.controller;

import java.util.List;
import java.util.Map;
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
        moveCars(cars, racingGameInfo.gameRound());
    }

    private RacingGameInfo getRacingGameInfoFromInput() {
        List<String> carNames = inputView.getCarNames();
        int gameRound = inputView.getTryCount();
        return new RacingGameInfo(carNames, gameRound);
    }

    private Cars createCarsForRace(RacingGameInfo racingGameInfo) {
        return new Cars(racingGameInfo);
    }

    private void moveCars(Cars cars, int gameRound) {
        while (gameRound-- > 0) {
            cars.moveCarForward();
            Map<String, Integer> gameSituation = cars.getCars();
        }
    }

    private void displayResults(Cars cars) {
        cars.getCars();
    }
}
