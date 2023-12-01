package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String SEPARATOR = ",";

    public static List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(String::trim)
                .toList();
    }
}
