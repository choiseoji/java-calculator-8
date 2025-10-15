package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    private final String inputMessage = "덧셈할 문자열을 입력해 주세요.";

    public String run() {

        printMessage();
        return getMessageFromUser();
    }

    private void printMessage() {
        System.out.println(inputMessage);
    }

    private String getMessageFromUser() {
        return Console.readLine();
    }
}
