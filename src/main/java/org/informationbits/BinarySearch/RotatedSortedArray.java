package org.informationbits.BinarySearch;

import java.util.List;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
public class RotatedSortedArray {
    public static int binarySearchRotated(List<Integer> nums, int target) {
        int start = 0, end = nums.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums.get(mid) == target) return mid;
            else {
                boolean isLeftSorted = isSorted(nums, start, mid);
                //Note - In some cases Left and Right both part could be sorted.
                if (isLeftSorted) {
                    if (numCouldExists(nums, start, mid, target)) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (numCouldExists(nums, mid, end, target)) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isSorted(List<Integer> nums, int start, int end) {
        /*
         * Note - For some cases checking start and end would not enough to determine that array is sorted.
         * e.g. - [1,3,1,1,1] and target is 3.
         * */
        int mid = (start + end) / 2;
        return nums.get(start) <= nums.get(mid) && nums.get(mid) <= nums.get(end);
    }

    private static boolean numCouldExists(List<Integer> nums, int start, int end, int target) {
        return target >= nums.get(start) && target <= nums.get(end);
    }
}
