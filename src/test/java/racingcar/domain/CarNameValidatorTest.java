package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameValidatorTest {

    @DisplayName("1대의 자동차 이름만 입력했을 경우")
    @Test
    void invalidateNameCount_singleCarName() {
        List<String> carNames = List.of("Car1");
        assertThatThrownBy(() -> CarNameValidator.validateNameCount(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 2대 이상 입력되어야 레이싱 경주가 가능합니다");
    }

    @DisplayName("2대 이상의 자동차 이름을 입력했을 경우")
    @Test
    void validateNameCount_multipleCarNames() {
        List<String> multipleCarNames = List.of("Car1", "Car2");
        CarNameValidator.validateNameCount(multipleCarNames);
    }
}
