package blatt2;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static blatt2.Blatt2_RegexPatterns.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Blatt2_RegexPatternsTest {
    @Test
    public void testFloat() {
        // AI generated values
        assertTrue(Pattern.matches(PATTERN_FLOAT, "1.23E10"));
        assertTrue(Pattern.matches(PATTERN_FLOAT, "-4.56e3"));
        assertTrue(Pattern.matches(PATTERN_FLOAT, "7.89E12"));
        assertTrue(Pattern.matches(PATTERN_FLOAT, "0.1e5"));
        assertTrue(Pattern.matches(PATTERN_FLOAT, "123E4"));
        assertTrue(Pattern.matches(PATTERN_FLOAT, "-0.00123E12"));
        assertTrue(Pattern.matches(PATTERN_FLOAT, "1E0"));
        assertTrue(Pattern.matches(PATTERN_FLOAT, "0"));
        assertTrue(Pattern.matches(PATTERN_FLOAT, "1"));
        assertTrue(Pattern.matches(PATTERN_FLOAT, "-1.2"));

        assertFalse(Pattern.matches(PATTERN_FLOAT, "1.23E"));
        assertFalse(Pattern.matches(PATTERN_FLOAT, "E10"));
        assertFalse(Pattern.matches(PATTERN_FLOAT, "1.2.3E4"));
        assertFalse(Pattern.matches(PATTERN_FLOAT, "1,23E5"));
        assertFalse(Pattern.matches(PATTERN_FLOAT, "1E2.3"));
        assertFalse(Pattern.matches(PATTERN_FLOAT, "1E2E3"));
        assertFalse(Pattern.matches(PATTERN_FLOAT, ".E5"));
        assertFalse(Pattern.matches(PATTERN_FLOAT, "1E"));
        assertFalse(Pattern.matches(PATTERN_FLOAT, "E"));
        assertFalse(Pattern.matches(PATTERN_FLOAT, "01.23E4"));
    }

    @Test
    public void testDate() {
        // AI generated values
        assertTrue(Pattern.matches(PATTERN_DATE, "2023-10-09T15:30:45.123"));
        assertTrue(Pattern.matches(PATTERN_DATE, "2000-01-01T00:00:00.000"));
        assertTrue(Pattern.matches(PATTERN_DATE, "2024-02-29T23:59:59.999"));
        assertTrue(Pattern.matches(PATTERN_DATE, "1999-12-31T12:34:56.789"));
        assertTrue(Pattern.matches(PATTERN_DATE, "2100-06-15T08:45:30.500"));
        //assertTrue(Pattern.matches(PATTERN_DATE, "2100-06-15T08:45:30X500"));

        assertFalse(Pattern.matches(PATTERN_DATE, "2023-13-01T00:00:00.000")); // Invalid month
        assertFalse(Pattern.matches(PATTERN_DATE, "2023-10-09T24:00:00.000")); // Invalid hour
        assertFalse(Pattern.matches(PATTERN_DATE, "2023-10-09T12:60:00.000")); // Invalid minute
        assertFalse(Pattern.matches(PATTERN_DATE, "2023-10-09T12:00:60.000")); // Invalid second
        assertFalse(Pattern.matches(PATTERN_DATE, "2023-10-09T12:00:00.1000")); // Invalid millisecond
        assertFalse(Pattern.matches(PATTERN_DATE, "2023-10-09 12:00:00.000")); // Missing 'T' separator
        assertFalse(Pattern.matches(PATTERN_DATE, "23-10-09T12:00:00.000")); // Year too short
        assertFalse(Pattern.matches(PATTERN_DATE, "2023-10-9T12:00:00.000")); // Day not zero-padded

    }

    @Test
    public void testKennzeichen() {
        // AI generated values
        assertTrue(Pattern.matches(PATTERN_KENNZEICHEN, "LÖ TA 248"));
        assertTrue(Pattern.matches(PATTERN_KENNZEICHEN, "M AB 123"));
        assertTrue(Pattern.matches(PATTERN_KENNZEICHEN, "B W 9999"));
        assertTrue(Pattern.matches(PATTERN_KENNZEICHEN, "KA FZ 7"));
        assertTrue(Pattern.matches(PATTERN_KENNZEICHEN, "WOB XY 555"));
        assertTrue(Pattern.matches(PATTERN_KENNZEICHEN, "S A 1"));
        assertTrue(Pattern.matches(PATTERN_KENNZEICHEN, "M AB 123 H"));
        assertTrue(Pattern.matches(PATTERN_KENNZEICHEN, "B W 9 E"));
        assertTrue(Pattern.matches(PATTERN_KENNZEICHEN, "KA FZ 700 E"));

        assertFalse(Pattern.matches(PATTERN_KENNZEICHEN, "MUNC AB 123")); // City code too long
        assertFalse(Pattern.matches(PATTERN_KENNZEICHEN, "M ABC 123")); // Owner initials too long
        assertFalse(Pattern.matches(PATTERN_KENNZEICHEN, "M AB 12345")); // Number part too long
        assertFalse(Pattern.matches(PATTERN_KENNZEICHEN, "M-AB-123")); // Incorrect separator
        assertFalse(Pattern.matches(PATTERN_KENNZEICHEN, "M AB123")); // Missing space before number
        assertFalse(Pattern.matches(PATTERN_KENNZEICHEN, "1 AB 123")); // City code starts with a number
        assertFalse(Pattern.matches(PATTERN_KENNZEICHEN, "M A1 123")); // Owner initials contain a number
        assertFalse(Pattern.matches(PATTERN_KENNZEICHEN, "MAB123")); // No spaces
        assertFalse(Pattern.matches(PATTERN_KENNZEICHEN, "M AB ")); // Missing number part
        assertFalse(Pattern.matches(PATTERN_KENNZEICHEN, "M AB 012")); // Number part begins with zero
        assertFalse(Pattern.matches(PATTERN_KENNZEICHEN, "M AB 123G")); // Invalid letter at the end (not H or E)
        assertFalse(Pattern.matches(PATTERN_KENNZEICHEN, "M AB 123HE")); // Too many letters at the end
        assertFalse(Pattern.matches(PATTERN_KENNZEICHEN, "M AB 123H")); // Missing space before H
        assertFalse(Pattern.matches(PATTERN_KENNZEICHEN, "M AB 123E")); // Missing space before E
    }
}