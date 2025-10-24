package calculator.application;

import calculator.service.Calculator;
import calculator.model.Operands;
import calculator.service.Parser;
import calculator.io.Input;
import calculator.io.Output;

public class StringAdder {

    private final Input input;
    private final Output output;
    private final Parser parser;
    private final Calculator calculator;

    public StringAdder(Input input, Output output) {
        this.input = input;
        this.output = output;
        this.parser = new Parser();
        this.calculator = new Calculator();
    }

    public void run() {

        String command = input.read();
        if (command == null || command.isBlank()) {
            output.print(0);
            return;
        }
        Operands operands = parser.parse(command);
        output.print(calculator.sum(operands));
    }
}
