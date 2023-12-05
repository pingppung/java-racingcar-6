package racingcar.domain.constant;

public enum ErrorMessage {
    NON_NUMERIC_INPUT("[ERROR] 숫자만 입력해주셔야 합니다."),
    MIN_ATTEMPTS("[ERROR] 1이상 입력되어야 레이싱 경주가 가능합니다."),
    NAME_LENGTH_RANGE("[ERROR] 자동차 이름은 1자 이상, 5자 이하만 가능합니다."),
    MIN_CAR_COUNT("[ERROR] 2대 이상 입력되어야 레이싱 경주가 가능합니다"),
    DUPLICATE_NAME("[ERROR] 자동차 이름이 중복됩니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
