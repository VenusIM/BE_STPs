package oop.practice;

public class User {

    private String password;

    public void initPassword(PasswordGenerator passwordGenerator) {

//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
//        String randomPassword = randomPasswordGenerator.generatePassword();

        String randomPassword = passwordGenerator.generatePassword();
        /**
         * 비밀번호는 최소 8자리 이상 최대 12자리 이하이어야 한다.
         */
        if(8 <= randomPassword.length() && randomPassword.length() <= 12) {
            this.password = randomPassword;
        }
    }

    public String getPassword() {
        return password;
    }
}
