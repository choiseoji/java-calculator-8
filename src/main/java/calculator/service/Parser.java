package calculator.service;

import calculator.model.Delimiters;
import calculator.model.Operands;

import java.util.List;
import java.util.regex.Pattern;

import static calculator.service.DelimiterHandler.CUSTOM_DELIMITER_PATTERN;

public class Parser {

    private final DelimiterHandler delimiterHandler;

    public Parser() {
        this.delimiterHandler = new DelimiterHandler();
    }

    public Operands parse(String command) {

        Delimiters delimiters = delimiterHandler.extractDelimiter(command);
        String operandsPart = removeDelimiterDeclaration(command);
        return extractOperands(operandsPart, delimiters);
    }

    private String removeDelimiterDeclaration(String command) {

        return command.replaceFirst(CUSTOM_DELIMITER_PATTERN, "");
    }

    private Operands extractOperands(String operandsPart, Delimiters delimiters) {

        Pattern endDelimiterPattern = Pattern.compile(".*(" + delimiters.toRegex() + ")$");
        if (endDelimiterPattern.matcher(operandsPart).matches()) {
            throw new IllegalArgumentException("잘못된 입력: 마지막에 구분자가 올 수 없습니다.");
        }

        String[] tokens = operandsPart.split(delimiters.toRegex());
        return new Operands(List.of(tokens));
    }

}
