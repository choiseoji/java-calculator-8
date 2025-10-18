package calculator;

public class CustomDelimeterHandler {

    public String extractCustomDelimeter(String command) {

        if (!hasCustomDelimeter(command))
            return null;

        int endOfDelimeter = command.indexOf("\\n");
        if (endOfDelimeter == -1)
            throw new IllegalArgumentException("커스텀 구분자는 '\\n'으로 끝나야 합니다.");

        String delimeter = command.substring(2, endOfDelimeter);
        validateDelimeter(delimeter);

        return delimeter;
    }

    public String removeDelimiterDeclaration(String command) {

        if (!hasCustomDelimeter(command))
            return command;

        int endOfDelimeter = command.indexOf("\\n");
        if (endOfDelimeter == -1)
            throw new IllegalArgumentException("커스텀 구분자는 '\\n'으로 끝나야 합니다.");

        return command.substring(endOfDelimeter + 2);
    }

    private boolean hasCustomDelimeter(String command) {

        if (command.startsWith("//"))
            return true;
        return false;
    }

    private void validateDelimeter(String delimeter) {

        if (delimeter.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("커스텀 구분자에 숫자를 넣을 수 없습니다.");
        }
    }
}
