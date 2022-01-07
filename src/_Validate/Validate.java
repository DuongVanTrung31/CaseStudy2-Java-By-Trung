package _Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static final String ACCOUNT_REGEX = "^(?=.*[a-z])(?=.*[0-9]).{8,12}$";
    private static final String PASS_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W\\S]).{8,16}$";
    private static final String PHONE_REGEX = "^[(](\\+84)[)][-][0-9]{9,}$";
    private static final String EMAIL_REGEX = "^[a-zA-Z][a-zA-Z0-9]{0,9}[._-]?[a-zA-Z0-9]{1,10}@[a-z]+\\.(com|vn)+$";

    public Validate() {
    }

    public boolean validateAccount(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validatePassword(String regex) {
        Pattern pattern = Pattern.compile(PASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validatePhone(String regex) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean validateEmail(String regex) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
