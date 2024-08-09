package org.informationbits.LinkedList.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.informationbits.LinkedList.datastructures.LinkedListNode;



public class PrintList<T> {
    public static void print(LinkedListNode head, Logger logger) {
        StringBuffer buffer = new StringBuffer("LinkedList data: ");
        if (head == null) buffer.append("empty");
        LinkedListNode curr = head;
        while (curr != null) {
            buffer.append(curr.data);
            buffer.append(" ");
            curr = curr.next;
        }
        logger.info(buffer.toString());
    }
}