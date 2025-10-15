package calculator;

public class Parser {
    public String[] run(String command) {

        String delimeter = null;
        CustomDelimeterHandler customDelimeterHandler = new CustomDelimeterHandler();
        if (customDelimeterHandler.hasCustomDelimeter(command)) {
            delimeter = customDelimeterHandler.extractCustomDelimeter(command);
            command = customDelimeterHandler.removeDelimiterDeclaration(command);
        }

        String regex = getRegularExpression(delimeter);
        return command.split(regex);
    }

    private String getRegularExpression(String delimeter) {

        String defaultDelimeter = ",|:";
        if (delimeter != null)
            defaultDelimeter += "|" + delimeter;
        return defaultDelimeter;
    }
}
