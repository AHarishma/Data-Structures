package com.company.linkedlist;

public class DetectCycle {
    public boolean detectCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        if(head == null) {
            return false;
        }

        while(hare != null && tortoise != null) {
            hare = hare.next;
            tortoise = tortoise.next.next;
            if(hare == tortoise) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Given a linked list. Detect any cycle/ loop in it. Return true or false
 */
