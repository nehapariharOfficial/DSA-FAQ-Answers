package org.informationbits.KElements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/reorganize-string/description/
 * https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
 */
public class ReorganizeChars {

    public static String reorganizeString(String ipStr) {
        PriorityQueue<CharInfo> maxHeap = getMaxHeap(ipStr);
        StringBuffer result = new StringBuffer();

        CharInfo prev = null, curr = maxHeap.size() > 0 ? maxHeap.poll() : null;
        while (curr != null) {
            result.append(curr.c);
            curr.freq--;
            if (prev != null) maxHeap.add(prev);
            prev = (curr.freq > 0) ? curr : null;
            curr = maxHeap.size() > 0 ? maxHeap.poll() : null;
        }

        return result.length() == ipStr.length() ? result.toString() : "";
    }

    private static PriorityQueue<CharInfo> getMaxHeap(String ipStr) {
        Map<Character, Integer> charToFrequency = new HashMap<Character, Integer>();
        for (Character c : ipStr.toCharArray()) {
            charToFrequency.put(c, charToFrequency.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<CharInfo> maxHeap = new PriorityQueue<CharInfo>(new Comparator<CharInfo>() {
            @Override
            public int compare(CharInfo o1, CharInfo o2) {
                return o2.freq - o1.freq;
            }
        });

        for (Map.Entry<Character, Integer> entry : charToFrequency.entrySet()) {
            maxHeap.add(new CharInfo(entry.getKey(), entry.getValue()));
        }
        return maxHeap;
    }

    static class CharInfo {
        char c;
        int freq;

        public CharInfo(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

}

