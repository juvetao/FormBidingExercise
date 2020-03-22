package se.ecutb.cheng.exercises.constants.regex;

public class RegexStorage {
    public static final String EMAIL_REGEX = "^(\\D)+(\\w)*((\\.(\\w)+)?)+@(\\D)+(\\w)*((\\.(\\D)+(\\w)*)+)?(\\.)[a-z]{2,}$";
    public static final String SWEDISH_PHONE_NUMBER_REGEX = "^((00|\\+)46)?(0?[2-9][0-9]{1,})$";
    public static final String SWEDISH_CELL_NUMBER_REGEX = "^((00|\\+)46)?(0?[2-9][0-9]{1,})$";
}
