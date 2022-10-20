package SKNI.KOD.Literaki.util;

public class Regexes {
    // Minimum: eight characters, one letter, one number
    public static final String EIGHT_LETTER_NUMBER = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    // Minimum: eight characters, one letter, one number, one special character
    public static final String EIGHT_LETTER_NUMBER_SPECIAL = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
    // Minimum: eight characters, one uppercase letter, one lowercase letter, one number
    public static final String EIGHT_ULETTER_LLETTER_NUMBER = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    // Minimum: eight characters, one uppercase letter, one lowercase letter, one number, one special character
    public static final String EIGHT_ULETTER_LLETTER_NUMBER_SPECIAL = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    // Regex for email validation
    public static final String EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
}
