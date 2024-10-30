package blatt2;

public class Blatt2_RegexPatterns {
    public static final String PATTERN_FLOAT = "^[+-]?(0|[1-9]\\d*)(\\.\\d+)?([Ee]\\d+)?$";
    public static final String PATTERN_DATE =
            "\\d{4}-(0[1-9]|1[012])-([012]\\d|3[01])T([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d\\.\\d{3}\\b";
    public static final String PATTERN_KENNZEICHEN =
            "([A-ZÄÜÖ]{1,3}) ([A-ZÄÜÖ]{1,2}) [1-9](\\d{1,3})?( [HE])?\\b";
    //Pattern pat = Pattern.compile("^[+-]?(0|[1-9]\\d*)(\\.\\d+)?([Ee]\\d+)?$");
}