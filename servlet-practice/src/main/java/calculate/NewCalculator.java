package calculate;

import java.util.List;

public class NewCalculator {
    private static final List<NewArithmeticOperator> ARITHMETIC_OPERATORS = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

//    public static int calculate(int operand1, String operator, int operand2) {

    //re-factoring
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
            return ARITHMETIC_OPERATORS.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator)) //
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2)) // int로 받기 위해 map을 사용
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
