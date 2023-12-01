package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.Parser;

public class InputView {
    private static final String INPUT_CARS_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_PROMPT = "시도할 회수는 몇회인가요?";

    public List<String> getCarNames() {
        return Parser.parseCarNames(inputWithPrompt(INPUT_CARS_PROMPT));
    }

    public String getTryCount() {
        return inputWithPrompt(INPUT_TRY_PROMPT);
    }

    private String inputWithPrompt(String prompt) {
        System.out.println(prompt);
        return Console.readLine().trim();
    }
}
