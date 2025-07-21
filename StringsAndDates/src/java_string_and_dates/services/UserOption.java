package java_string_and_dates.services;

import java.util.Locale;

public enum UserOption {
//    Константные выражения
    HELP,
    REPORT,
    EXIT,
    UNKNOWN;

//    Методы
    public static UserOption checkUserOption(String option) {
        for (UserOption i : UserOption.values()) {
            if (i.name().equalsIgnoreCase(option)) {
                UserOption optionToUpperCase = UserOption.valueOf(option.toUpperCase());
                return optionToUpperCase;
            }
        }

        return null;
    }
}
