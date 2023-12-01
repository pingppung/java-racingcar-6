package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public void validateNameCount(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 2대 이상 입력되어야 레이싱 경주가 가능합니다");
        }
    }

    public void validateNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
            }
        }
    }

    public void validateNameDuplicate(List<String> carNames) {
        Set<String> names = new HashSet<>(carNames);
        if (names.size() != carNames.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 중복됩니다.");
        }
    }
}
