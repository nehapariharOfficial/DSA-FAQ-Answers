package org.informationbits.InPlaceLinkedListManipulation.solutionsuit;

import org.informationbits.InPlaceLinkedListManipulation.datastructures.LinkedListNode;

public class SwapNodes {
    /**
     * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/
     */
    public static LinkedListNode swapNodes(LinkedListNode head, int k) {
        LinkedListNode curr = head, front, end = head;

        for (int i = 1; i < k; i++) {
            if (curr == null) return head;
            curr = curr.next;
        }

        front = curr;
        end = head;

        while (curr.next != null) {
            curr = curr.next;
            end = end.next;
        }

        int tmp = front.data;
        front.data = end.data;
        end.data = tmp;
        return head;
    }

    /**
     * https://leetcode.com/problems/swap-nodes-in-pairs/description/
     */
    public static LinkedListNode swapPairs(LinkedListNode head) {
        LinkedListNode pHead = head, pTail = pHead != null ? pHead.next : null;
        while (pTail != null) {
            int tmpValue = pHead.data;
            pHead.data = pTail.data;
            pTail.data = tmpValue;
            pHead = pHead.next != null ? pHead.next.next : null;
            pTail = pHead != null ? pHead.next : null;
        }
        return head;
    }
}