package org.informationbits.KWayMerge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KSmallestPairsTest {

    private static void isEqual(List<List<Integer>> actual, int[][] expected) {
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[0].length; j++) {
                assertEquals(expected[i][j], actual.get(i).get(j));
            }
        }
    }

    @Test
    void kSmallestPairs() {
        //Case 1:
        int[] listA = new int[]{-10, -4, 0, 0, 6};
        int[] listB = new int[]{3, 5, 6, 7, 8, 100};
        int k = 10;
        int[][] expected = new int[][]{{-10, 3}, {-10, 5}, {-10, 6}, {-10, 7}, {-10, 8}, {-4, 3}, {-4, 5}, {-4, 6}, {-4, 7}, {0, 3}};
        List<List<Integer>> actual = KSmallestPairs.kSmallestPairs(listA, listB, k);
        isEqual(actual, expected);

        //Case 1:
        listA = new int[]{1, 2, 4, 5, 6};
        listB = new int[]{3, 5, 7, 9};
        k = 3;
        expected = new int[][]{};
        actual = KSmallestPairs.kSmallestPairs(listA, listB, k);
        isEqual(actual, expected);

    }
}