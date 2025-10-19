package calculator.application;

import calculator.domain.PositiveCalculator;
import calculator.domain.Parser;
import calculator.io.Input;
import calculator.io.Output;

public class StringAdder {

    private final Input input;
    private final Output output;
    private final Parser parser;
    private final PositiveCalculator positiveCalculator;

    /**
     * StringAdder 생성자
     *
     * 입력과 출력 방식을 외부에서 주입받아,
     * 다양한 입출력 구현체를 유연하게 사용할 수 있도록 한다.
     *
     * @param input 문자열 입력을 담당하는 Input의 구현체
     * @param output 결과 출력을 담당하는 Output의 구현체
     */
    public StringAdder(Input input, Output output) {
        this.input = input;
        this.output = output;
        this.parser = new Parser();
        this.positiveCalculator = new PositiveCalculator();
    }

    public void run() {

        String command = input.read();
        if (command == null || command.isBlank()) {
            output.print(0);
            return;
        }
        String[] tokens = parser.run(command);
        int result = positiveCalculator.calculate(tokens);
        output.print(result);
    }
}
