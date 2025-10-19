package calculator.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class ConsoleInput implements Input{

    @Override
    public String read() {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try{
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
