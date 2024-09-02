package org.informationbits.TwoHeaps.solutionsuit;


import org.informationbits.TwoHeaps.util.IVPair;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Similar Questions -
 * https://leetcode.com/problems/ipo/description/
 * https://www.geeksforgeeks.org/maximum-amount-of-capital-required-for-selecting-at-most-k-projects/
 * https://algo.monster/liteproblems/502
 **/

public class MaximizeCapital {
    public static int maximumCapital(int currentCapital, int maxProject, int[] capitals, int[] profits) {

        assert (capitals.length == profits.length);

        PriorityQueue<IVPair> capitalMinHeap = capitalMinHeap(capitals);
        PriorityQueue<IVPair> currentProfitMaxHeap = currentProfitMaxHeap(profits.length);

        int projectSelected = 0;
        while (projectSelected < maxProject) {
            while (capitalMinHeap.size() > 0 && currentCapital >= capitalMinHeap.peek().value) {
                IVPair idxValuePair = capitalMinHeap.poll();
                currentProfitMaxHeap.add(new IVPair(idxValuePair.index, profits[idxValuePair.index]));
            }
            if (currentProfitMaxHeap.size() > 0) {
                IVPair ivPair = currentProfitMaxHeap.poll();
                int profit = ivPair.value;
                currentCapital += profit;
                projectSelected++;
            } else {
                break;
            }
        }
        return currentCapital;
    }

    private static PriorityQueue<IVPair> capitalMinHeap(int[] capitals) {
        Comparator<IVPair> comCapital = Comparator.comparingInt(p -> p.value);
        PriorityQueue<IVPair> minCapitalHeap = new PriorityQueue<IVPair>(capitals.length, comCapital);

        for (int i = 0; i < capitals.length; i++) {
            minCapitalHeap.add(new IVPair(i, capitals[i]));
        }
        return minCapitalHeap;
    }

    private static PriorityQueue<IVPair> currentProfitMaxHeap(int size) {

        PriorityQueue<IVPair> profitMaxHeap = new PriorityQueue<IVPair>(size, new Comparator<IVPair>() {
            @Override
            public int compare(IVPair o1, IVPair o2) {
                return o2.value - o1.value;
            }
        });
        return profitMaxHeap;
    }
}
