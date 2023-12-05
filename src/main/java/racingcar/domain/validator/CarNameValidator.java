package racingcar.domain.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.constant.ErrorMessage;

public class CarNameValidator {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateNameCount(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.MIN_CAR_COUNT.getMessage());
        }
    }

    public static void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_RANGE.getMessage());
        }
    }

    public static void validateNameDuplicate(List<String> carNames) {
        Set<String> names = new HashSet<>(carNames);
        if (names.size() != carNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.getMessage());
        }
    }
}
