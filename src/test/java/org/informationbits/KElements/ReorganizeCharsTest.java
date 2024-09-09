package org.informationbits.KElements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReorganizeCharsTest {

    @Test
    void reorganizeString() {
        //Case 1:
        String actual = ReorganizeChars.reorganizeString("abb");
        String expected = "bab";
        assertEquals(actual, expected);

        //Case 2:
        actual = ReorganizeChars.reorganizeString("i");
        expected = "i";
        assertEquals(actual, expected);
    }
}