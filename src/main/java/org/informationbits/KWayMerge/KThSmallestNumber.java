package org.informationbits.KWayMerge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Similar Questions -
 * https://stackoverflow.com/questions/73637036/kth-smallest-element-in-multiple-sorted-arrays
 * https://www.geeksforgeeks.org/find-m-th-smallest-value-in-k-sorted-arrays/
 * https://algo.monster/liteproblems/502
 **/
public class KThSmallestNumber {
    public static int kSmallestNumber(List<List<Integer>> lists, int k) {
        double totalSize = getSumOfListSize(lists);
        int[] indexes = new int[lists.size()];
        Arrays.fill(indexes, 0);

        if (totalSize == 0) return 0;

        if (k > totalSize) k = (int) totalSize;

        PriorityQueue<HeapElement> minHeap = getInitializedMinHeap(lists, indexes);

        HeapElement min = null;
        while (k-- > 0) {
            min = minHeap.poll();
            List<Integer> list = lists.get(min.listIndex);
            if (indexes[min.listIndex] < list.size()) {
                minHeap.add(new HeapElement(list.get(indexes[min.listIndex]++), min.listIndex));
            }
        }
        return min.val;
    }

    private static double getSumOfListSize(List<List<Integer>> lists) {
        int totalSize = 0;
        for (List<Integer> list : lists) {
            totalSize += list.size();
        }
        return totalSize;
    }

    private static PriorityQueue<HeapElement> getInitializedMinHeap(List<List<Integer>> lists, int[] indexes) {
        PriorityQueue<HeapElement> minHeap = new PriorityQueue<HeapElement>(new Comparator<HeapElement>() {
            @Override
            public int compare(HeapElement o1, HeapElement o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            if (!list.isEmpty()) {
                minHeap.add(new HeapElement(list.get(indexes[i]++), i));
            }
        }
        return minHeap;
    }

    static class HeapElement {
        int val;
        int listIndex;

        HeapElement(int v, int listIdx) {
            this.val = v;
            this.listIndex = listIdx;
        }
    }
}
