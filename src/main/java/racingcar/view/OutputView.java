package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String POSITION_CHARARCTER = "-";

    public static void printExecutionResult() {
        System.out.println(EXECUTION_RESULT);
    }

    public static void printRaceRoundResults(Map<String, Integer> gameSituation) {
        for (Map.Entry<String, Integer> entry : gameSituation.entrySet()) {
            String carName = entry.getKey();
            int position = entry.getValue();
            System.out.println(carName + " : " + POSITION_CHARARCTER.repeat(position));
        }
    }

    public static void printFinalWinner(List<String> winners) {
        System.out.print(FINAL_WINNER);
        for (String winner : winners) {
            System.out.print(winner + " ");
        }
    }
}
