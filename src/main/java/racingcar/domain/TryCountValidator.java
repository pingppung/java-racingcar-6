package racingcar.domain;

public class TryCountValidator {

    public int validateNonNumberic(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주셔야 합니다.");
        }
    }

}
