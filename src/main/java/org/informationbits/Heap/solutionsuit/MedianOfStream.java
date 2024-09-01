package org.informationbits.Heap.solutionsuit;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Similar Questions -
 * https://leetcode.com/problems/find-median-from-data-stream/
 * https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 * https://www.interviewbit.com/blog/find-median-in-a-stream/
 **/
public class MedianOfStream {
    PriorityQueue<Integer> greaterNumberMinHeap, smallerNumberMaxHeap;

    public MedianOfStream() {
        greaterNumberMinHeap = new PriorityQueue<Integer>(Comparator.naturalOrder());
        smallerNumberMaxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
    }

    public void insertNum(int num) {
        // Note - greaterNumberMinHeap.size() > 0 is safety check in case evaluation order of If changes otherwise it is not needed.
        if (isZeroNumProcessed() || (greaterNumberMinHeap.size() > 0 && num >= greaterNumberMinHeap.peek())) {
            greaterNumberMinHeap.add(num);
        } else {
            smallerNumberMaxHeap.add(num);
        }
        balanceHeaps();
    }

    private void balanceHeaps() {
        if (smallerNumberMaxHeap.size() > greaterNumberMinHeap.size()) {
            greaterNumberMinHeap.add(smallerNumberMaxHeap.poll());
        } else if (smallerNumberMaxHeap.size() + 1 < greaterNumberMinHeap.size()) {
            smallerNumberMaxHeap.add(greaterNumberMinHeap.poll());
        }
    }

    private boolean isZeroNumProcessed() {
        return greaterNumberMinHeap.size() + smallerNumberMaxHeap.size() == 0;
    }

    private boolean isTotalCountEven() {
        return (greaterNumberMinHeap.size() + smallerNumberMaxHeap.size()) % 2 == 0;
    }

    public double findMedian() {
        int maxOfSmallerNumber = smallerNumberMaxHeap.size() > 0 ? smallerNumberMaxHeap.peek() : 0;
        int minOfGreaterNumber = greaterNumberMinHeap.size() > 0 ? greaterNumberMinHeap.peek() : 0;
        if (isTotalCountEven()) return (maxOfSmallerNumber + minOfGreaterNumber) / 2.0;
        return minOfGreaterNumber;
    }
}
