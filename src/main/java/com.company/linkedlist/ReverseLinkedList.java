package com.company.linkedlist;

public class ReverseLinkedList {
    ListNode reverseLinkedList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while(current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
       return prev;
    }
}
