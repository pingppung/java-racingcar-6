package racingcar.domain;

import java.util.List;

public class CarNameValidator {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public void validateNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
            }
        }
    }
}
