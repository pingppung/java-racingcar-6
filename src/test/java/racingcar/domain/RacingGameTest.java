package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class RacingGameTest extends NsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        List<String> carNames = List.of("Car1", "Car2", "Car3");
        RacingGameInfo racingGameInfo = new RacingGameInfo(carNames, 5);
        cars = new Cars(racingGameInfo);
    }

    @DisplayName("자동차_이름_제대로_n개_입력시_참가하는_자동차_리스트_크기_n인지_확인")
    @Test
    void validateNonNumberic() {
        assertEquals(3, cars.getCars().size());
    }

    @DisplayName("랜덤_숫자_3_이하_정지_4_이상_전진")
    @Test
    void validateRandomForward() {
        int FORWARD = 4;
        int STOP = 3;
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b", "3");
                    assertThat(output()).contains("a : ---", "b : -", "최종 우승자 : a");
                },
                FORWARD, STOP, FORWARD, STOP, FORWARD, FORWARD
        );
    }

    @DisplayName("단독_우승자_확인")
    @Test
    void checkSingleWinner() {
        cars.cars = List.of(new Car("a", 3),
                new Car("b", 2),
                new Car("c", 1));
        List<String> winners = cars.findWinners();
        assertThat(winners).isEqualTo(List.of("a"));
    }

    @DisplayName("공동_우승자_확인")
    @Test
    void checkMultipleWinner() {
        cars.cars = List.of(new Car("a", 3),
                new Car("b", 3),
                new Car("c", 1));
        List<String> winners = cars.findWinners();
        assertThat(winners).isEqualTo(List.of("a", "b"));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
