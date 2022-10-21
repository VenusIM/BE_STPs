package oop.calculateExample.calculate;

public interface NewArithmeticOperator {
    boolean supports(String operator);
//    int calculate(int operand1, int operand2);
    // re-factoring
    int calculate(PositiveNumber operand1, PositiveNumber operand2);

}
