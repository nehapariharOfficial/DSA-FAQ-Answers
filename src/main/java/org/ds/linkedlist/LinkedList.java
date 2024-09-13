package org.ds.linkedlist;

import java.util.List;

public class LinkedList {
    private LinkedListNode head;

    public LinkedList(){
        this.head = null;
    }

    public LinkedList(List<String> list) {
        if (list == null || list.isEmpty()) return;
        list.forEach(l -> insertNodeAtHead(new LinkedListNode(l)));
    }

    public LinkedListNode insertNodeAtHead(LinkedListNode node){
     if(this.head == null){
         head = node;
     }else{
         node.next = head;
         this.head = node;
     }
     return node;
    }

    public int size(){
        LinkedListNode node = this.head;
        int count = 0;
        if(node == null) return count;
        while(node.next!=null) {
            count++;
            node = node.next;
        }
        return count;
    }


   /* public LinkedListNode clone (LinkedListNode head){
        LinkedListNode newHead = null, newCurr = null, newNext = null, curr = head;
        while (curr != null) {
            newCurr = new LinkedListNode(curr.data);
            if(curr == head){
                newHead = newCurr = curr;
                curr = curr.next;
            }else{
                newCurr = curr.next;
                curr
            }
        }


    }*/
}

class LinkedListNode{
    public String data;
    public LinkedListNode next;
    public LinkedListNode(String data){
        this.data = data;
        this.next = null;
    }
}