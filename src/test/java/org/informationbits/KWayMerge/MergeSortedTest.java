package org.informationbits.KWayMerge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortedTest {

    @Test
    void mergeSorted() {
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] actual = MergeSorted.mergeSorted(new int[]{6, 7, 8, 9, 10, 0, 0, 0, 0, 0}, 5, new int[]{1, 2, 3, 4, 5}, 5);
        assertArrayEquals(expected, actual);
    }
}