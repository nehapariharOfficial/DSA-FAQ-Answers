package org.informationbits.BinarySearch;

/**
 * https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/solutions/1119801/java-c-python-binary-search/
 */
public class MaximizeGivenIndex {
    public static int maxValue(int n, int index, int maxSum) {
        int minIdxVal = 0, maxIdxVal = (maxSum - n);
        while (minIdxVal < maxIdxVal) {
            /**
             * In general, while computing the `mid` addition of 1 is not needed
             * But in this case we are not shifting lower value due to which we have to add one to maintain
             * progress in each iteration of for loop.
             * */
            int midVal = (minIdxVal + maxIdxVal + 1) / 2;
            if (getSum(index, midVal, n) > (maxSum - n)) {
                maxIdxVal = midVal - 1;
            } else {
                minIdxVal = midVal;
            }
        }
        //We are adding one because initially we have subtracted one.
        return maxIdxVal + 1;
    }

    private static long getSum(int index, int indexValue, int arrSize) {
        int leftMostIndexVal = Math.max((indexValue - index), 0);
        int leftSideNumCnt = indexValue - leftMostIndexVal + 1;
        // Formula used - ((First Term + Last Term)*(Num Count))/2
        long leftSideAPSum = (long) (leftSideNumCnt) * (leftMostIndexVal + indexValue) / 2;


        int rightMostIndexVal = Math.max((indexValue - (arrSize - 1 - index)), 0);
        int rightSideNumCnt = indexValue - rightMostIndexVal + 1;
        long rightSideAPSum = (long) (rightSideNumCnt) * (rightMostIndexVal + indexValue) / 2;

        //Subtracting value [indexValue] at provided index because it is counted in both the Sums.
        return (leftSideAPSum + rightSideAPSum) - indexValue;
    }
}
