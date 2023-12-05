package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.constant.ErrorMessage;
import racingcar.domain.validator.TryCountValidator;

public class TryCountValidatorTest {
    @DisplayName("숫자가 아닌 값을 입력했을 경우 예외 발생")
    @Test
    void invalidateNonNumberic() {
        String name = "a";
        assertThatThrownBy(() -> TryCountValidator.validateNonNumberic(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NON_NUMERIC_INPUT.getMessage());
    }

    @DisplayName("숫자를 입력했을 경우 정상")
    @Test
    void validateNonNumberic() {
        String name = "2";
        TryCountValidator.validateNonNumberic(name);
    }

    @DisplayName("최소 시도 횟수인 1미만의 값을 입력했을 경우 예외 발생")
    @Test
    void invalidateMinTryCount() {
        int count = 0;
        assertThatThrownBy(() -> TryCountValidator.validateMinTryCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MIN_ATTEMPTS.getMessage());
    }

    @DisplayName("최소 시도 횟수인 1이상의 값을 입력했을 경우")
    @Test
    void validateMinTryCount() {
        int count = 1;
        TryCountValidator.validateMinTryCount(count);
    }
}
