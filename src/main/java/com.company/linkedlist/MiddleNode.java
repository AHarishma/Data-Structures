package com.company.linkedlist;

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null) {
            if (hare.next == null) {
                return tortoise;
            }
            tortoise = tortoise.next;
            hare = hare.next.next;
        }

        return tortoise;
    }
}

/**
 * Time: O(n), space: O(1)
 * Use two pointers. One move two step, the other move one step. (Hare and Tortoise)
 */
