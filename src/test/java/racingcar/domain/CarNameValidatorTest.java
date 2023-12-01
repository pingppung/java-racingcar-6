package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameValidatorTest {

    @DisplayName("1대의 자동차 이름만 입력했을 경우 예외 발생")
    @Test
    void invalidateNameCount_singleCarName() {
        List<String> carNames = List.of("Car1");
        assertThatThrownBy(() -> CarNameValidator.validateNameCount(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 2대 이상 입력되어야 레이싱 경주가 가능합니다");
    }

    @DisplayName("2대 이상의 자동차 이름을 입력했을 경우 정상")
    @Test
    void validateNameCount_multipleCarNames() {
        List<String> multipleCarNames = List.of("Car1", "Car2");
        CarNameValidator.validateNameCount(multipleCarNames);
    }

    @DisplayName("자동차 이름이 1자 미만일 경우 예외 발생")
    @Test
    void invalidateNameLength_lessThanMinimumLength() {
        String name = "";
        assertThatThrownBy(() -> CarNameValidator.validateNameLength(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
    }

    @DisplayName("자동차 이름이 5자 초과일 경우 예외 발생")
    @Test
    void invalidateNameLength_greaterThanMaximumLength() {
        String name = "123456";
        assertThatThrownBy(() -> CarNameValidator.validateNameLength(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
    }

    @DisplayName("자동차 이름이 1자 이상 5자 이하인 경우 정상")
    @Test
    void validateNameLengthInRange() {
        String name = "Car";
        CarNameValidator.validateNameLength(name);
    }

    @DisplayName("자동차 이름이 중복되는 경우 예외 발생")
    @Test
    void invalidateNameDuplicate() {
        List<String> duplicatedNames = List.of("Car1", "Car2", "Car2");
        assertThatThrownBy(() -> CarNameValidator.validateNameDuplicate(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름이 중복됩니다.");
    }

    @DisplayName("중복되는 자동차 이름이 없을 경우 정상")
    @Test
    void validateNameDuplicate() {
        List<String> uniqueCarNames = List.of("Car1", "Car2", "Car3");
        CarNameValidator.validateNameDuplicate(uniqueCarNames);
    }
}
