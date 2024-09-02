package org.informationbits.KWayMerge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KThSmallestNumberTest {

    @Test
    void kSmallestNumber() {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(Arrays.asList(2, 6, 8));
        lists.add(Arrays.asList(3, 7, 10));
        lists.add(Arrays.asList(5, 8, 11));


        int actual = KThSmallestNumber.kSmallestNumber(lists, 5);
        int expected = 7;
        assertEquals(expected, actual);
    }
}