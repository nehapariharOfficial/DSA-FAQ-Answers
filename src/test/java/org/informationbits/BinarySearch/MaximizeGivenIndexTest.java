package org.informationbits.BinarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximizeGivenIndexTest {

    @Test
    void maxValue() {
        int actual = MaximizeGivenIndex.maxValue(11, 7, 45);
        int expected = 7;
        assertEquals(actual, expected);
    }
}