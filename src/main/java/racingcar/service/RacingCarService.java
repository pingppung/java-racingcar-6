package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.utils.InputValidator;
import racingcar.utils.Message;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.OutputView;

public class RacingCarService {
    private static final int MOVE_CONDITION = 4;
    private static List<Car> carList;

    public RacingCarService() {
        carList = new ArrayList<>();
    }

    public List<Car> registerCars(List<String> carName) {
        validateCarNames(carName);
        for (String name : carName) {
            carList.add(new Car(name));
        }
        return carList;
    }

    private void validateCarNames(List<String> carName) {
        for (String name : carName) {
            InputValidator.validateEmptyInput(name);
            InputValidator.validateInputLength(name);
        }
        InputValidator.validateDuplicateInput(carName);
    }

    public void moveCar() {
        for (Car car : carList) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            if (randomNumber >= MOVE_CONDITION) {
                car.move();
            }
            OutputView.printRaceRoundResults(car.getName(), car.getMoveCount());
        }
    }

    public String findWinners() {
        int maxMoveCount = carList.get(0).getMoveCount();

        List<String> winners = carList.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(Car::getName)
                .collect(Collectors.toList());

        return classifyWinners(winners);
    }

    private String classifyWinners(List<String> winners) {
        return Message.FINAL_WINNER_MESSAGE.getMessage() + String.join(", ", winners);
    }
}
