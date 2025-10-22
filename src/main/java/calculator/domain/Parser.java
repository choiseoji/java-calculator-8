package calculator.domain;

public class Parser {

    private final CustomDelimiterHandler customDelimiterHandler;

    public Parser() {
        this.customDelimiterHandler = new CustomDelimiterHandler();
    }

    public String[] run(String command) {

        String customDelimiter = customDelimiterHandler.extractCustomDelimiter(command);
        String content = customDelimiterHandler.removeDelimiterDeclaration(command);
        customDelimiterHandler.validateContent(content, customDelimiter);

        String regex = buildRegex(customDelimiter);
        return content.split(regex);
    }

    private String buildRegex(String delimiter) {

        String defaultDelimiter = ",|:";
        if (delimiter != null)
            defaultDelimiter += "|" + delimiter;
        return defaultDelimiter;
    }
}
