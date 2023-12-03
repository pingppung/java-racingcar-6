package racingcar.view;

public class OutputView {
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String POSITION_CHARARCTER = "-";

    public static void printRaceRoundResults(String name, int position) {
        System.out.println(name + " : " + POSITION_CHARARCTER.repeat(position));
    }

    public static void printFinalWinner(String result) {
        System.out.println(FINAL_WINNER + result);
    }
}
