package calculator.model;

import java.util.List;

public class Operands {

    private List<Integer> operands;

    public Operands(List<String> operands) {

        if (operands.isEmpty())
            throw new IllegalArgumentException("잘못된 입력: 구분자만 존재하거나 숫자가 없습니다.");

        this.operands = List.copyOf(
                operands.stream()
                .map(this::toInteger)
                .map(this::validatePositive)
                .toList()
        );
    }

    private Integer toInteger(String operand) {

        try {
            return Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력: 숫자만 입력할 수 있습니다. 입력값=" + operand);
        }
    }

    private Integer validatePositive(Integer operand) {

        if (operand <= 0)
            throw new IllegalArgumentException("잘못된 입력: 양수만 입력할 수 있습니다. 입력값=" + operand);
        return operand;
    }

    public List<Integer> getOperands() {
        return operands;
    }
}
