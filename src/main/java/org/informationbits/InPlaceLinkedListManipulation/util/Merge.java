package org.informationbits.InPlaceLinkedListManipulation.util;

import org.informationbits.InPlaceLinkedListManipulation.datastructures.LinkedListNode;

public class Merge {
    public static LinkedListNode mergeAlternate(LinkedListNode h1, LinkedListNode h2) {
        if (h1 == null) return h2;
        LinkedListNode curr1 = h1, curr2 = h2;
        while (curr1 != null && curr2 != null) {
            LinkedListNode tmp = curr2.next;
            curr2.next = curr1.next;
            curr1.next = curr2;

            curr2 = tmp;
            curr1 = curr1.next;
            if (curr1.next == null) {
                curr1.next = curr2;
                break;
            } else {
                curr1 = curr1.next;
            }
        }
        return h1;
    }
}
