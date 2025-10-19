package calculator.domain;

public class PositiveCalculator {

    public int calculate(String[] tokens) {

        int result = 0;
        for(String token : tokens) {

            int number = Integer.parseInt(token.trim());
            if (number <= 0) {
                throw new IllegalArgumentException("음수 또는 0은 계산할 수 없습니다.");
            }
            result += number;
        }
        return result;
    }
}
