package oop.practice;

public class WrongFixedPasswordGenerator implements PasswordGenerator{
    @Override
    public String generatePassword() {
        return "1234567"; // 7글자
    }
}
