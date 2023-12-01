package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    private void validate(String carName) {
        CarNameValidator.validateNameLength(carName);
    }

    public void moveForward() {
        this.position++;
    }
}
