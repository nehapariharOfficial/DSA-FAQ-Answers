package org.informationbits.TwoHeaps.solutionsuit;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * [* * * * *] Similar Questions -
 * https://leetcode.com/problems/sliding-window-median/solutions/1942580/easiest-python-o-n-log-k-two-heaps-lazy-removal-96-23/ *
 * https://www.geeksforgeeks.org/median-of-sliding-window-in-an-array/
 * https://usaco.guide/problems/cses-1076-sliding-median/solution
 * https://thewayofnada.medium.com/a-very-thorough-solution-to-sliding-window-median-and-some-heap-magics-5091a3ed1cdc
 **/

public class SlidingWindowMedian {

    public static double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> smallerNumberMaxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        PriorityQueue<Integer> greaterNumberMinHeap = new PriorityQueue<Integer>();

        Map<Integer, Integer> removedNumToCnt = new HashMap<Integer, Integer>();
        double[] medians = new double[nums.length - k + 1];
        int mediansIndex = 0;

        for (int i = 0; i < k; i++) {
            smallerNumberMaxHeap.add(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            greaterNumberMinHeap.add(smallerNumberMaxHeap.poll());
        }

        medians[mediansIndex++] = findMedian(smallerNumberMaxHeap, greaterNumberMinHeap, k);
        int heapBalance = 0;
        for (int i = k; i < nums.length; i++) {
            int numToRemove = nums[i - k];
            int numToInsert = nums[i];
            removedNumToCnt.put(numToRemove, removedNumToCnt.getOrDefault(numToRemove, 0) + 1);

            if (numToRemove <= smallerNumberMaxHeap.peek() && numToInsert > smallerNumberMaxHeap.peek()) {
                heapBalance = -2;
            } else if (numToRemove > smallerNumberMaxHeap.peek() && numToInsert <= smallerNumberMaxHeap.peek()) {
                heapBalance = 2;
            }

            insertNum(numToInsert, smallerNumberMaxHeap, greaterNumberMinHeap);

            balanceValidNums(heapBalance, smallerNumberMaxHeap, greaterNumberMinHeap);
            heapBalance = 0;

            cleanUp(removedNumToCnt, smallerNumberMaxHeap);
            cleanUp(removedNumToCnt, greaterNumberMinHeap);

            medians[mediansIndex++] = findMedian(smallerNumberMaxHeap, greaterNumberMinHeap, k);
        }
        return medians;
    }

    private static void balanceValidNums(int heapBalance, PriorityQueue<Integer> smallerNumberMaxHeap, PriorityQueue<Integer> greaterNumberMinHeap) {
        /**
         * We need to move top element from one heap to another whenever insertion and removal is done from
         * different heap. In other cases count of valid element would not change (in the respective heap).
         * Another interesting point is - for the above-mentioned cases element that is moved, would be always valid.
         * Think -  why are we not doing heapBalance computation in this function :)
         * */
        if (heapBalance == -2) {
            smallerNumberMaxHeap.add(greaterNumberMinHeap.poll());
        } else if (heapBalance == 2) {
            greaterNumberMinHeap.add(smallerNumberMaxHeap.poll());
        }
    }

    private static void insertNum(Integer numToInsert, PriorityQueue<Integer> smallerNumberMaxHeap, PriorityQueue<Integer> greaterNumberMinHeap) {
        if (numToInsert <= smallerNumberMaxHeap.peek()) {
            smallerNumberMaxHeap.add(numToInsert);
        } else {
            greaterNumberMinHeap.add(numToInsert);
        }
    }

    private static void cleanUp(Map<Integer, Integer> removedNumToCnt, PriorityQueue<Integer> heap) {
        while (removedNumToCnt.getOrDefault(heap.peek(), 0) > 0) {
            int numToRemove = heap.peek();
            int cnt = removedNumToCnt.get(numToRemove);
            removedNumToCnt.put(heap.poll(), cnt - 1);
        }
    }

    private static double findMedian(PriorityQueue<Integer> smallerNumberMaxHeap, PriorityQueue<Integer> greaterNumberMinHeap, int k) {
        /**
         * No need to add size check for respective heap to avoid null pointer exception. Because smallerNumberMaxHeap
         * size will be always >=1 and minOfGreaterNumber heap size will zero in the case where window size is <=1 but in that
         * case we would not be accessing(peeking) it.
         **/
        double maxOfSmallerNumber = smallerNumberMaxHeap.peek();
        double minOfGreaterNumber = k % 2 == 0 ? greaterNumberMinHeap.peek() : 0;
        return (maxOfSmallerNumber + minOfGreaterNumber) * (k % 2 == 0 ? 0.5 : 1);
    }
}