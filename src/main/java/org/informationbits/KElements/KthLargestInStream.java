package org.informationbits.KElements;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * https://www.geeksforgeeks.org/kth-largest-element-in-a-stream/
 */
public class KthLargestInStream {
    PriorityQueue<Integer> minHeap;
    int heapSize;

    /*
     * nums[] array could have size less than k.
     * */
    public void KthLargestInStream(int k, int[] nums) {
        heapSize = k;
        minHeap = new PriorityQueue<Integer>(heapSize);
        for (int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < heapSize) {
            minHeap.add(val);
        } else if (minHeap.peek() < val) {
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();
    }
}
