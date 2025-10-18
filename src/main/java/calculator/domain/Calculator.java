package calculator.domain;

public class Calculator {

    public int calculate(String[] tokens) {

        int result = 0;
        for(String token : tokens) {
            result += Integer.parseInt(token);
        }
        return result;
    }
}
