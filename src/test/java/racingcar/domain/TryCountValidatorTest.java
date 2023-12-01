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
}
