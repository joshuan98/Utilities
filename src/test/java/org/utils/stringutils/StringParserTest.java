package org.utils.stringutils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.utils.exceptions.InvalidStringInputException;

public class StringParserTest {

    // methodBeingTested_inputGiven_expectedOutput
    // happy path: "Hello|World" -> 2 parts
    @Test
    void splitString_oneSeparator_expectTwoParts() throws InvalidStringInputException {
        String inputString = "Hello|World";
        String separator = "\\|";
        StringParser sp = new StringParser();
        ArrayList<String> stringParts = sp.splitString(inputString, separator);
        assertEquals(2, stringParts.size());
    }

    // failure case to check how it is handled
    // on null throw invalid string input
    @Test
    void splitString_nullInput_expectException() {
        String inputString = null;
        String separator = "\\|";
        StringParser sp = new StringParser();
        // ArrayList<String> stringParts = sp.splitString(inputString, separator);
        // assertEquals(0, stringParts.size());
        assertThrows(InvalidStringInputException.class,
            () -> sp.splitString(inputString, separator));
    }
}
