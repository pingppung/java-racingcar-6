package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.validator.CarNameValidator;

public class Cars {
    private static final int MOVE_CONDITION = 4;
    private static final int INIT_POSITION = 0;
    protected List<Car> cars;

    public Cars(RacingGameInfo racingGameInfo) {
        this.cars = new ArrayList<>();
        this.registerCars(racingGameInfo.carNames());
    }

    public void registerCars(List<String> carNames) {
        validate(carNames);
        for (String name : carNames) {
            cars.add(addCar(name, INIT_POSITION));
        }
    }

    private Car addCar(String carName, int position) {
        return new Car(carName, position);
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

    private int getMaxMoveCount() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<String> findWinners() {
        int maxMoveCount = getMaxMoveCount();

        return cars.stream()
                .filter(car -> car.getPosition() == maxMoveCount)
                .map(Car::getName)
                .toList();
    }

    public Map<String, Integer> getCars() {
        Map<String, Integer> gameSituation = new HashMap<>();
        for (Car car : cars) {
            gameSituation.put(car.getName(), car.getPosition());
        }
        return gameSituation;
    }
}
