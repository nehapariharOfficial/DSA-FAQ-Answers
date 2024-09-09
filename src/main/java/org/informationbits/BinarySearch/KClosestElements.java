package org.informationbits.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-closest-elements/description/
 * https://www.geeksforgeeks.org/find-k-closest-elements-given-value/
 */
public class KClosestElements {
    public static List<Integer> findClosestElements(int[] nums, int k, int target) {
        assert (nums.length >= k);
        int start = 0, end = nums.length - k;
        while (start < end) {
            int mid = (start + end) / 2;
            //We are not using Math.abs
            if (target - nums[mid] > nums[mid + k] - target) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }
        ArrayList<Integer> closestElms = new ArrayList<Integer>();
        while (k > 0) {
            closestElms.add(nums[start++]);
            k--;
        }
        return closestElms;
    }
}
