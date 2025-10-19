package calculator.domain;

public class Parser {

    private final CustomDelimeterHandler customDelimeterHandler;

    public Parser() {
        this.customDelimeterHandler = new CustomDelimeterHandler();
    }

    public String[] run(String command) {

        String customDelimeter = customDelimeterHandler.extractCustomDelimeter(command);
        String content = customDelimeterHandler.removeDelimiterDeclaration(command);
        customDelimeterHandler.validateContent(content, customDelimeter);

        String regex = buildRegex(customDelimeter);
        return content.split(regex);
    }

    private String buildRegex(String delimeter) {

        String defaultDelimeter = ",|:";
        if (delimeter != null)
            defaultDelimeter += "|" + delimeter;
        return defaultDelimeter;
    }
}
