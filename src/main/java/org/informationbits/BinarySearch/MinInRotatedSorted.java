package org.informationbits.BinarySearch;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class MinInRotatedSorted {

    /**
     * Note - If numbers are not unique then this approach might be returning min from non pivot index.
     */
    private static boolean isSorted(int[] nums, int start, int end) {
        /*
         * Note - For some cases checking start and end would not enough to determine that array is sorted.
         * e.g. - [1,3,1,1,1] and target is 3.
         * */
        int mid = (start + end) / 2;
        return nums[start] <= nums[mid] && nums[mid] <= nums[end];
    }

    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        int min = nums[start];
        while (start < end) {
            int mid = (start + end) / 2;
            boolean isLeftSorted = isSorted(nums, start, mid);
            //Note - In some cases Left and Right both part could be sorted.
            if (isLeftSorted) {
                min = Math.min(min, nums[start]);
                start = mid + 1;
            } else {
                //No need to compute min here even if right part is sorted because we are not ignoring mid.
                end = mid;
            }
        }
        min = Math.min(min, nums[start]);
        return min;
    }
}
