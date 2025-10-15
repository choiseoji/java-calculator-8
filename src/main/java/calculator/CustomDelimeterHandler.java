package calculator;

public class CustomDelimeterHandler {

    public boolean hasCustomDelimeter(String command) {

        if (command.startsWith("//"))
            return true;
        return false;
    }

    public String extractCustomDelimeter(String command) {

        int endOfDelimeter = command.indexOf("\\n");
        if (endOfDelimeter == -1)
            throw new IllegalArgumentException("");
        return command.substring(2, endOfDelimeter);
    }
}
