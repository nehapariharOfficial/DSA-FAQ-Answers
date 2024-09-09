package org.informationbits.SubsetBased;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/permutations/description/
 */
public class Permutations {

    public static ArrayList<String> permute(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);

        boolean[] used = new boolean[word.length()];
        Arrays.fill(used, false);

        ArrayList<String> res = new ArrayList<String>();
        backtrack(res, chars, new char[chars.length], used, 0);
        return res;
    }

    private static void backtrack(ArrayList<String> res, char[] chars, char[] buffer, boolean[] used, int bufferIndex) {
        if (bufferIndex == chars.length) {
            res.add(new String(buffer)); //
        } else {
            for (int i = 0; i < chars.length; i++) {
                /**
                 * If used then do not use or do not use if previous similar character is not used it will help
                 * in maintaining order in case of duplicate elements.
                 * */
                if (used[i] || (i > 0 && !used[i - 1] && chars[i] == chars[i - 1])) continue;
                buffer[bufferIndex] = chars[i];
                used[i] = true;
                backtrack(res, chars, buffer, used, bufferIndex + 1);
                used[i] = false;
            }
        }
    }
}
