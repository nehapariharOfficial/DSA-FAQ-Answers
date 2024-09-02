package org.informationbits.InPlaceLinkedListManipulation.util;

import org.informationbits.InPlaceLinkedListManipulation.datastructures.LinkedListNode;

public class Search {
    public static LinkedListNode[] find(LinkedListNode head, int index) {
        if (head == null || index <= 0) return new LinkedListNode[]{null, null};
        LinkedListNode prev = null, curr = head;
        for (int i = 2; i <= index; i++) {
            if (curr == null) return new LinkedListNode[]{null, null};
            prev = curr;
            curr = curr.next;
        }
        return new LinkedListNode[]{prev, curr};
    }
}
