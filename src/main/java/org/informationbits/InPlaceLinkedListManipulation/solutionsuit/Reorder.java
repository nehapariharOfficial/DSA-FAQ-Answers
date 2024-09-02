package org.informationbits.InPlaceLinkedListManipulation.solutionsuit;

import org.informationbits.InPlaceLinkedListManipulation.datastructures.LinkedListNode;

import static org.informationbits.InPlaceLinkedListManipulation.solutionsuit.ReverseVariants.reverseV1;
import static org.informationbits.InPlaceLinkedListManipulation.util.Merge.mergeAlternate;

public class Reorder {
    /**
     * Input  - 1 → 2 → 3
     * Output - 1 → 3 → 2
     * <p>
     * Input  - 4 → 2 → 7 → 8 → 9 → 0 → 1
     * Output - 4 → 1 → 2 → 0 → 7 → 9 → 8
     */
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