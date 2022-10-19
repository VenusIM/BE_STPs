package oop.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * TDD, BDD (Given, When, Then)
 * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
 * 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.
 * 경계조건에 대해 테스트 코드를 작성해야 한다.
 */
public class PasswordValidateTest {

    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordSuccessTest() {
        assertThatCode(() -> PasswordValidator.validate("testtest"))
                .doesNotThrowAnyException();

    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과할 경우 IllegalArgumentException 발생한다.")
    @ParameterizedTest //경계 조건의 테스트
    @ValueSource(strings = {"1234567", "1234567891234"})
        // 참고 >> https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-parameterized-tests/
    void validatePasswordExceptionTest(String password) {
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PasswordValidator.WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
    }
}
