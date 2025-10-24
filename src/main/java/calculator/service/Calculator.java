package calculator.service;

import calculator.model.Operands;

public class Calculator {

    public Integer sum(Operands operands) {

        return operands
                .getOperands()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
