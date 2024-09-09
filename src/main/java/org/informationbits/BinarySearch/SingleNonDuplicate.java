package org.informationbits.BinarySearch;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 * https://www.geeksforgeeks.org/find-the-element-that-appears-once-in-a-sorted-array/
 */
public class SingleNonDuplicate {
    public static int findSingleNonDuplicateNum(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            mid = mid % 2 == 0 ? mid : mid - 1;
            if (nums[mid] == nums[mid + 1]) start = mid + 2;
            else end = mid;
        }
        return nums[start];
    }
}
