package org.informationbits.SubsetBased;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenerateParenthesesTest {

    @Test
    void generateCombinations() {
        List<String> actual = GenerateParentheses.generateCombinations(1);
        List<String> expected = new ArrayList<String>();
        expected.add("()");

        assertEquals(actual, expected);
    }
}