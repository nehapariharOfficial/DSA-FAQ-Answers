package org.informationbits.SubsetBased;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationsTest {

    @Test
    void permute() {
        List<String> actual = Permutations.permute("aab");
        List<String> expected = new ArrayList<>();
        expected.add("aab");
        expected.add("aba");
        expected.add("baa");
        assertEquals(actual, expected);
    }
}