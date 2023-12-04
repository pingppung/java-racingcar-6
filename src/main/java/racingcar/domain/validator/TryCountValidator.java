package racingcar.domain.validator;

import racingcar.domain.constant.ErrorMessage;

public class TryCountValidator {
    private static final int MINIMUM_ATTEMPTS = 1;

    public static int validateNonNumberic(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_INPUT.getMessage());
        }
    }

    public static void validateMinTryCount(int count) {
        if (count < MINIMUM_ATTEMPTS) {
            throw new IllegalArgumentException(ErrorMessage.MIN_ATTEMPTS.getMessage());
        }
    }
}
