package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TryCountValidatorTest {
    @DisplayName("숫자가 아닌 값을 입력했을 경우 예외 발생")
    @Test
    void invalidateNonNumberic() {
        String name = "a";
        assertThatThrownBy(() -> TryCountValidator.validateNonNumberic(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해주셔야 합니다.");
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
                .hasMessage("[ERROR] 1이상 입력되어야 레이싱 경주가 가능합니다.");
    }

    @DisplayName("최소 시도 횟수인 1이상의 값을 입력했을 경우")
    @Test
    void validateMinTryCount() {
        int count = 1;
        TryCountValidator.validateMinTryCount(count);
    }
}
