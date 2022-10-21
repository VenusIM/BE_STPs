package oop.calculateExample;

public class Calculator {
    public static int calculate(int operand1, String operator, int operand2) {
       /* AS-IS
       int result = 0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
        }
        return result;
        */

        // re-factoring 1
        return ArithmeticOperator.calculate(operand1, operator, operand2);
    }
}
