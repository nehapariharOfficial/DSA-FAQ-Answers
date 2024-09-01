package org.informationbits.Heap.solutionsuit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SlidingWindowMedianTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void medianSlidingWindow() {
        //Case 1:
        int[] nums = new int[]{6, 5, 9, 5, 4, 9, 1, 7, 5, 5};
        int k = 4;
        double[] expectedOutput = new double[]{5.50000, 5.00000, 7.00000, 4.50000, 5.50000, 6.00000, 5.00000};
        double[] actualOutput = SlidingWindowMedian.medianSlidingWindow(nums, k);
        assertArrayEquals(actualOutput, expectedOutput);

        //Case 2:
        nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        k = 5;
        expectedOutput = new double[]{1, 3, 3, 5};
        actualOutput = SlidingWindowMedian.medianSlidingWindow(nums, k);
        assertArrayEquals(actualOutput, expectedOutput);

        //Case 3:
        nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        k = 3;
        expectedOutput = new double[]{1, -1, -1, 3, 5, 6};
        actualOutput = SlidingWindowMedian.medianSlidingWindow(nums, k);
        assertArrayEquals(actualOutput, expectedOutput);

        //Case 4:
        nums = new int[]{1, 1, 1, 1};
        k = 2;
        expectedOutput = new double[]{1.0, 1.0, 1.0};
        actualOutput = SlidingWindowMedian.medianSlidingWindow(nums, k);
        assertArrayEquals(actualOutput, expectedOutput);

        //Case 5:
        nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        k = 3;
        expectedOutput = new double[]{1.0, -1.0, -1.0, 3.0, 5.0, 6.0};
        actualOutput = SlidingWindowMedian.medianSlidingWindow(nums, k);
        assertArrayEquals(actualOutput, expectedOutput);
    }
}