package racingcar.domain;

public class TryCountValidator {
    private static final int MINIMUM_ATTEMPTS = 1;

    public int validateNonNumberic(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주셔야 합니다.");
        }
    }

    public void validateTryCount(int count) {
        if (count < MINIMUM_ATTEMPTS) {
            throw new IllegalArgumentException("[ERROR] 1이상 입력되어야 레이싱 경주가 가능합니다.");
        }
    }
}
