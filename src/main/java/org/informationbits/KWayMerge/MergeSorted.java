package org.informationbits.KWayMerge;

/**
 * Function to merge two sorted arrays in-place.
 * First array has empty space in the end to accommodate second array elements.
 */
public class MergeSorted {
    public static int[] mergeSorted(int[] numsOne, int elementsInOne, int[] numsTwo, int elementsInTwo) {
        int idxOne = elementsInOne - 1;
        int idxTwo = elementsInTwo - 1;
        int resultIdx = numsOne.length - 1;

        while (idxTwo >= 0) {
            numsOne[resultIdx--] = idxOne >= 0 && numsOne[idxOne] > numsTwo[idxTwo] ? numsOne[idxOne--] : numsTwo[idxTwo--];
        }
        return numsOne;
    }
}
