package org.informationbits.KElements;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 * https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
 */
public class FrequentElements {

    public static List<Integer> topKFrequent(int[] arr, int k) {
        Map<Integer, Integer> integerToFrequency = new HashMap<Integer, Integer>();
        for (Integer x : arr) {
            integerToFrequency.put(x, integerToFrequency.getOrDefault(x, 0) + 1);
        }

        ArrayList<Integer> frequentElements = new ArrayList<Integer>();
        PriorityQueue<int[]> minHeap = getMinHeap(k);
        for (Map.Entry<Integer, Integer> entry : integerToFrequency.entrySet()) {
            add(minHeap, new int[]{entry.getKey(), entry.getValue()}, k);
        }

        for (int[] integerAndFreq : minHeap) {
            frequentElements.add(integerAndFreq[0]);
        }
        return frequentElements;
    }

    private static PriorityQueue<int[]> getMinHeap(int maxHeapSize) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(maxHeapSize, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        return minHeap;
    }

    private static int[] add(PriorityQueue<int[]> minHeap, int[] integerAndFreq, Integer maxHeapSize) {
        if (minHeap.size() == maxHeapSize) {
            if (integerAndFreq[1] > minHeap.peek()[1]) {
                minHeap.poll();
                minHeap.add(integerAndFreq);
            }
        } else {
            minHeap.add(integerAndFreq);
        }
        return minHeap.peek();
    }

}
