package org.informationbits.InPlaceLinkedListManipulation.solutionsuit;

import org.informationbits.InPlaceLinkedListManipulation.datastructures.LinkedListNode;

import static org.informationbits.InPlaceLinkedListManipulation.solutionsuit.ReverseVariants.reverseV1;
import static org.informationbits.InPlaceLinkedListManipulation.util.Merge.mergeAlternate;

/**
 * https://leetcode.com/problems/reorder-list/description/
 */
public class Reorder {
    public static LinkedListNode reorderList(LinkedListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;

        LinkedListNode slowPtr = head, fastPtr = head.next.next;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        LinkedListNode secondPartHead;
        if (fastPtr == null) {
            secondPartHead = reverseV1(slowPtr.next);
            slowPtr.next = null;
        } else {
            secondPartHead = reverseV1(slowPtr.next.next);
            slowPtr.next.next = null;
        }
        LinkedListNode firstPartHead = head;
        return mergeAlternate(firstPartHead, secondPartHead);
    }
}