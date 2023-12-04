package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.domain.Cars;
import racingcar.domain.RacingGameInfo;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startRace() {
        RacingGameInfo racingGameInfo = getRacingGameInfoFromInput();
        Cars cars = createCarsForRace(racingGameInfo);
        moveCars(cars, racingGameInfo.gameRound());
        determineWinner(cars);
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
        outputView.printExecutionResult();
        moveCarsForRounds(cars, gameRound);
    }

    private void moveCarsForRounds(Cars cars, int gameRound) {
        while (gameRound-- > 0) {
            cars.moveCarForward();
            Map<String, Integer> gameSituation = cars.getCars();
            outputView.printRaceRoundResults(gameSituation);
        }
    }

    private void determineWinner(Cars cars) {
        List<String> winners = cars.findWinners();
        outputView.printFinalWinner(winners);
    }
}
