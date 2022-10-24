package was.calculate;

public class DivisionOperator implements NewArithmeticOperator {
    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    /*
    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {

        // re-factoring
        // : 높은 응집도를 가진 사칙연산들 중 낮은 결합도로 분리 함으로서 나누기에 관련된 요구사항만 반영 가능해진다.
        if(operand2 == 0) {
            throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
        }
        return operand1 / operand2;
    }
    */

    // re-factoring
    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {

        // re-factoring
        // : 높은 응집도를 가진 사칙연산들 중 낮은 결합도로 분리 함으로서 나누기에 관련된 요구사항만 반영 가능해진다.

        /* PositiveNumber의 validate로 인해 불필요한 코드가 되었다.
        if(operand2.toInt() == 0) {
            throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
        }
        */

        return operand1.toInt() / operand2.toInt();
    }
}
