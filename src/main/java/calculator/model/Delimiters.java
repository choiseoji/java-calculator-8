package calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delimiters {

    private static final String COMMA = ",";
    private static final String COLON = ":";
    private List<String> delimiters;
    private static final List<String> DEFAULT_DELIMITERS = List.of(COMMA, COLON);

    public Delimiters() {
        this.delimiters = List.copyOf(DEFAULT_DELIMITERS);
    }

    public Delimiters(String customDelimiter) {

        validateDelimiter(customDelimiter);
        List<String> combined = new ArrayList<>(DEFAULT_DELIMITERS);
        combined.add(customDelimiter);
        this.delimiters = List.copyOf(combined);
    }

    private void validateDelimiter(String customDelimiter) {

        if (customDelimiter.matches("\\d")) {
            throw new IllegalArgumentException("잘못된 구분자: 숫자는 사용할 수 없습니다. 입력값=" + customDelimiter);
        }
    }

    public String toRegex() {
        return delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }

}
