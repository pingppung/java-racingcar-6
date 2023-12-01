package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int MOVE_CONDITION = 4;
    private static final int INIT_POSITION = 0;
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(String name) {
        cars.add(new Car(name, INIT_POSITION));
    }

    public void moveCarForward() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generate();
            if (randomNumber >= MOVE_CONDITION) {
                car.moveForward();
            }
        }
    }
}
