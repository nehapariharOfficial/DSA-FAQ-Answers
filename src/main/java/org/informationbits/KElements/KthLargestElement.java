package org.informationbits.KElements;


import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * https://www.geeksforgeeks.org/kth-smallest-largest-element-in-unsorted-array/
 */
public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int x : nums) {
            if (minHeap.size() == k) {
                if (x > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(x);
                }
            } else {
                minHeap.add(x);
            }
        }
        return minHeap.size() == k ? minHeap.peek() : -1;
    }
}
