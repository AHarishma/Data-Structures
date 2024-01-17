package com.company.linkedlist;

public class ReverseLinkedList {
    ListNode reverseLinkedList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while(current != null) {
            current.next = prev;
            prev = current;
            current = current.next;
        }
       return prev;
    }
}
