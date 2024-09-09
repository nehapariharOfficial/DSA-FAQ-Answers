package org.informationbits.SubsetBased;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/description/
 * https://www.geeksforgeeks.org/backtracking-to-find-all-subsets/
 */
public class FindSubsets {
    public static List<List<Integer>> findAllSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        result.add(list);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<List<Integer>> newerLists = clone(result);
            for (List<Integer> l : newerLists) {
                l.add(num);
            }
            result.addAll(newerLists);
        }
        return result;
    }

    private static List<List<Integer>> clone(List<List<Integer>> inList) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<Integer> list : inList) {
            List<Integer> cloneList = new ArrayList<Integer>();
            cloneList.addAll(list);
            result.add(cloneList);
        }
        return result;
    }

}
