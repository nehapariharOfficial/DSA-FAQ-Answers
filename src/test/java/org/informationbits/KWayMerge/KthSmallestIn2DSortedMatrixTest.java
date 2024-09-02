package org.informationbits.KWayMerge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthSmallestIn2DSortedMatrixTest {

    @Test
    void kthSmallestElement() {
        //Case 1:
        int[][] matrix = new int[][]{{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};
        int k = 3;
        int actual = KthSmallestIn2DSortedMatrix.kthSmallestElement(matrix, k);
        int expeced = 5;
        assertEquals(actual, expeced);
    }
}