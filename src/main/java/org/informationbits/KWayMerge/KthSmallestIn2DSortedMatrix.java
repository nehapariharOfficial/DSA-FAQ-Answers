package org.informationbits.KWayMerge;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Similar Questions -
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 * https://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array/
 **/

public class KthSmallestIn2DSortedMatrix {
    public static int kthSmallestElement(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                /*
                 * In the int[] array
                 * 0 index is x coordinate
                 * 1 index is y coordinate
                 * 2 index is the value present in the respective input matrix.
                 * */
                if (o1[2] - o2[2] == 0) {
                    if (o1[0] == o2[0]) return o1[1] - o2[1];
                    return o1[0] - o2[0];
                }
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < matrix.length; i++) {
            minHeap.add(new int[]{i, 0, matrix[i][0]});
        }

        int kthMin = Integer.MAX_VALUE;
        while (k > 0 && minHeap.size() > 0) {
            int[] elm = minHeap.poll();
            kthMin = elm[2];

            if (elm[1] + 1 < matrix[elm[0]].length)
                minHeap.add(new int[]{elm[0], elm[1] + 1, matrix[elm[0]][elm[1] + 1]});
            k--;
        }
        return kthMin;
    }

}
