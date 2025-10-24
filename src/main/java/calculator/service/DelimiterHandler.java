package calculator.service;

import calculator.model.Delimiters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterHandler {
    public static final String CUSTOM_DELIMITER_PATTERN = "^//(.)\\\\n";

    public Delimiters extractDelimiter(String command) {

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN)
                .matcher(command);

        if (matcher.find()) {

            String customDelimiter = matcher.group(1);
            return new Delimiters(customDelimiter);
        }
        return new Delimiters();
    }
}
