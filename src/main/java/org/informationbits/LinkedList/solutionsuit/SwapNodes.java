package org.informationbits.LinkedList.solutionsuit;

import org.informationbits.LinkedList.datastructures.LinkedListNode;

public class SwapNodes {
    /**
     * Input  - 4 → 2 → 10 → 8 → 20 → 0 → 2  & k = 3
     * Output - 4 → 2 → 20 → 8 → 10 → 0 → 2
     * <p>
     * Input  - 9 → 5 → 8 → 12 → 1 → 3 → 6 → 11 → 4 → 5 → 9 & k = 8
     * Output - 9 → 5 → 8 → 11 → 1 → 3 → 6 → 12 → 4 → 5 → 9
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
     * Input  - 1 → 2 → 3 → 4 → 5 → 6
     * Output - 2 → 1 → 4 → 3 → 6 → 5
     * <p>
     * Input  - 10 → 20 → 30 → 40 → 50
     * Output - 20 → 10 → 40 → 30 → 50
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