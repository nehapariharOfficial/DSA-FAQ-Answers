package org.informationbits.SubsetBased;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 */
public class SubsetsSum {
    public static List<List<Integer>> getKSumSubsets(int[] nums, int sum) {
        //Memory to store intermediary result to use concept of Dynamic Programming.
        boolean[][] isSubSetPossible = new boolean[nums.length + 1][sum + 1];
        for (int row = 0; row < isSubSetPossible.length; row++) {
            for (int col = 0; col < isSubSetPossible[0].length; col++) {
                isSubSetPossible[row][col] = col == 0;
            }
        }

        for (int row = 1; row <= nums.length; row++) {
            for (int col = 1; col <= sum; col++) {
                if (col - nums[row - 1] >= 0) {
                    //Case 1: Could we get the Sum by including the number
                    isSubSetPossible[row][col] = isSubSetPossible[row - 1][col] || isSubSetPossible[row - 1][col - nums[row - 1]];
                } else {
                    //Case 2: Could we get the Sum by excluding the number
                    isSubSetPossible[row][col] = isSubSetPossible[row - 1][col];
                }
            }
        }

        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(subsets, isSubSetPossible, nums, isSubSetPossible.length - 1, isSubSetPossible[0].length - 1, new ArrayList<Integer>());
        return subsets;
    }

    private static void generateSubsets(List<List<Integer>> subsets, boolean[][] memory, int[] nums, int row, int col,
                                        List<Integer> buffer) {
        if (col == 0) {
            subsets.add(new ArrayList<>(buffer));
            return;
        }

        if (memory[row][col]) {
            if (memory[row - 1][col]) {
                generateSubsets(subsets, memory, nums, row - 1, col, buffer);
            }
            if ((col - nums[row - 1]) >= 0 && memory[row - 1][col - nums[row - 1]]) {
                List<Integer> newBuffer = new ArrayList<>(buffer);
                newBuffer.add(nums[row - 1]);
                generateSubsets(subsets, memory, nums, row - 1, (col - nums[row - 1]), newBuffer);
            }
        }
    }
}
