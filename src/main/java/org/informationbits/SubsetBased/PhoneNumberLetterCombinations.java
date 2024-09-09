package org.informationbits.SubsetBased;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class PhoneNumberLetterCombinations {
    public List<String> letterCombinations(String digits) {
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) return combinations; //
        combinations.add("");
        for (char digitC : digits.toCharArray()) {
            int digit = digitC - '0';
            assert (digit >= 1);
            combinations = extendCombination(combinations, mapping[digit]);
        }
        return combinations;
    }

    private List<String> extendCombination(List<String> combinations, String chars) {
        List<String> newCombinations = new ArrayList<>();
        for (String combination : combinations) {
            for (char c : chars.toCharArray()) {
                newCombinations.add(combination + c);
            }
        }
        return newCombinations;
    }
}
