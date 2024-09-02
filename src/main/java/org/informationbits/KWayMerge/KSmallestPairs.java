package org.informationbits.KWayMerge;

import java.util.*;

/**
 * [* * * * *] Similar Questions -
 * Check the approaches used to solve the problem.
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 * https://www.geeksforgeeks.org/find-k-pairs-smallest-sums-two-arrays/
 **/
public class KSmallestPairs {
    public static List<List<Integer>> kSmallestPairs(int[] listA, int[] listB, int k) {
        PriorityQueue<HeapElm> minHeap = new PriorityQueue<HeapElm>();
        HeapElm firstElm = new HeapElm(0, 0, listA[0] + listB[0]);
        minHeap.add(firstElm);

        Set<HeapElm> indexAccessed = new HashSet<HeapElm>();
        indexAccessed.add(firstElm);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (k > 0 && minHeap.size() > 0) {
            HeapElm e = minHeap.poll();
            List<Integer> list = new ArrayList<Integer>();
            list.add(listA[e.row]);
            list.add(listB[e.column]);
            result.add(list);
            k--;

            if (e.row + 1 < listA.length) {
                HeapElm elm = new HeapElm(e.row + 1, e.column, listA[e.row + 1] + listB[e.column]);
                if (!indexAccessed.contains(elm)) {
                    minHeap.add(elm);
                    indexAccessed.add(elm);
                }
            }

            if (e.column + 1 < listB.length) {
                HeapElm elm = new HeapElm(e.row, e.column + 1, listA[e.row] + listB[e.column + 1]);
                if (!indexAccessed.contains(elm)) {
                    minHeap.add(elm);
                    indexAccessed.add(elm);
                }
            }
        }
        return result;
    }

    static class HeapElm implements Comparable {
        int row, column;
        double sum;

        HeapElm(int i, int j, int sum) {
            this.row = i;
            this.column = j;
            this.sum = sum;
        }


        @Override
        public int compareTo(Object o) {
            HeapElm elm = ((HeapElm) o);
            if (this.sum == elm.sum) {
                if (this.row == elm.row) return this.column - elm.column;
                return this.row - elm.row;
            } else {
                return this.sum - elm.sum >= 0 ? 1 : -1;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

        @Override
        public boolean equals(Object o) {
            HeapElm elm = ((HeapElm) o);
            return row == elm.row && column == elm.column;
        }
    }
}
