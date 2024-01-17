package com.company.linkedlist;

public class MiddleNode {
    public int findMiddleNode(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        if(head == null) {
            return -1;
        }

        while(hare != null) {
            if(hare.next == null) {
                return tortoise.val;
            }
            tortoise = tortoise.next;
            hare = hare.next.next;
        }

        return tortoise.val;
    }
}

/**
 * Time: O(n), space: O(1)
 * Use two pointers. One move two step, the other move one step. (Hare and Tortoise)
 */
