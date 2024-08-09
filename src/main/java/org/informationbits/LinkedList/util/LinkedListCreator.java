package org.informationbits.LinkedList.util;


import org.informationbits.LinkedList.datastructures.LinkedListNode;

//TODO: Make it generic.
public class LinkedListCreator<T> {
    public LinkedListNode head;

    public LinkedListCreator() {
        this.head = null;
    }

    public LinkedListCreator(int[] lst) {
        if (lst == null || lst.length < 1) return;
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst[i]);
            insertNodeAtHead(newNode);
        }
    }

    public static int size(LinkedListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static LinkedListNode[] find(LinkedListNode head, int index) {
        if (head == null || index<=0) return new LinkedListNode[]{null, null};
        LinkedListNode prev = null, curr =head;
        for (int i=2; i<=index;i++) {
           if (curr == null) return new LinkedListNode[]{null, null};
           prev = curr;
           curr = curr.next;
        }
        return new LinkedListNode[]{prev, curr};
    }

    public static LinkedListNode clone(LinkedListNode head) {
        LinkedListNode newHead = null, newCurr = null, newPrev = null, curr = head;

        while (curr != null) {
            newCurr = new LinkedListNode(curr.data);
            if (newPrev != null) newPrev.next = newCurr;
            if (newHead == null) newHead = newCurr;
            newPrev = newCurr;
            curr = curr.next;
        }
        return newHead;
    }

    private void insertNodeAtHead(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
}