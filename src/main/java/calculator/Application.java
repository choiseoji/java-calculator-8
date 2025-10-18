package calculator;

import calculator.application.StringAdder;
import calculator.io.ConsoleInput;
import calculator.io.ConsoleOutput;
import calculator.io.Input;
import calculator.io.Output;

public class Application {
    public static void main(String[] args) {

        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();

        StringAdder stringAdder = new StringAdder(input, output);
        stringAdder.run();
    }
}
