package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements Input{

    @Override
    public String read() {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
