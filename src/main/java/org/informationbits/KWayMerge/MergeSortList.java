package org.informationbits.KWayMerge;

import org.informationbits.InPlaceLinkedListManipulation.datastructures.LinkedList;
import org.informationbits.InPlaceLinkedListManipulation.datastructures.LinkedListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Similar Questions -
 * https://www.geeksforgeeks.org/merge-k-sorted-arrays/
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 **/
public class MergeSortList {
    public static LinkedListNode mergeKLists(List<LinkedList> lists) {
        PriorityQueue<LinkedListNode> minHeap = new PriorityQueue<LinkedListNode>(new Comparator<LinkedListNode>() {
            @Override
            public int compare(LinkedListNode o1, LinkedListNode o2) {
                return o1.data - o2.data;
            }
        });

        for (LinkedList list : lists) {
            if (list != null && list.head != null) minHeap.add(list.head);
        }

        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode curr = dummy;
        while (minHeap.size() > 0) {
            LinkedListNode node = minHeap.poll();
            curr.next = node;
            if (node.next != null) {
                minHeap.add(node.next);
                node.next = null;
            }
            curr = node;
        }
        return dummy.next;
    }
}
