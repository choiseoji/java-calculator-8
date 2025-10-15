package calculator;

public class CustomDelimeterHandler {

    public boolean hasCustomDelimeter(String command) {

        if (command.startsWith("//"))
            return true;
        return false;
    }
}
