package oop.calculateExample;

import java.util.Arrays;

public enum ArithmeticOperator {
    // 아래 선언한 추상 메서드를 Enum 각각 overriding
    ADDITION("+"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    }, SUBTRACTION("-"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    }, MULTIPLICATION("*"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    }, DIVISION("/"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }

    public abstract int arithmeticCalculate(final int operand1, final int operand2);

    // 외부에 노출되는 public interface
    public static int calculate(int operand1, String operator, int operand2) {
        ArithmeticOperator arithmeticOperator =
                Arrays.stream(values()) // 모든 enum 값을 가져옴
                .filter(v -> v.operator.equals(operator)) // 인자 값과 같은지
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다.")); // 같은게 없다면 Exception 발생

        return arithmeticOperator.arithmeticCalculate(operand1, operand2);
    }
}
