package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.validator.CarNameValidator;

public class Cars {
    private static final int MOVE_CONDITION = 4;
    private static final int INIT_POSITION = 0;
    private final List<Car> cars;

    public Cars(RacingGameInfo racingGameInfo) {
        this.cars = new ArrayList<>();
        this.addCar(racingGameInfo.carNames());
    }

    private void addCar(List<String> carNames) {
        validate(carNames);
        for (String name : carNames) {
            cars.add(new Car(name, INIT_POSITION));
        }
    }

    private void validate(List<String> carNames) {
        CarNameValidator.validateNameCount(carNames);
        CarNameValidator.validateNameDuplicate(carNames);
    }

    public void moveCarForward() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generate();
            if (randomNumber >= MOVE_CONDITION) {
                car.moveForward();
            }
        }
    }

    public Map<String, Integer> getCars() {
        Map<String, Integer> gameSituation = new HashMap<>();
        for (Car car : cars) {
            gameSituation.put(car.getName(), car.getPosition());
        }
        return gameSituation;
    }
}
