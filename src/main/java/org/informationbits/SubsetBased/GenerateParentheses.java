package org.informationbits.SubsetBased;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateParentheses {

    public static ArrayList<String> generateCombinations(int n) {
        ArrayList<String> combinations = new ArrayList<String>();
        if (n == 0) return combinations;
        char[] buffer = new char[2 * n];
        backtrack(combinations, buffer, 0, n, n);
        return combinations;
    }

    private static void backtrack(List<String> combinations, char[] buffer, int bufferIndex, int left, int right) {
        if (left == 0 && right == 0) {
            combinations.add(new String(buffer));
            return;
        }

        if (left > 0) {
            buffer[bufferIndex] = '(';
            backtrack(combinations, buffer, bufferIndex + 1, left - 1, right);
        }

        if (left < right) {
            buffer[bufferIndex] = ')';
            backtrack(combinations, buffer, bufferIndex + 1, left, right - 1);
        }
    }
}
