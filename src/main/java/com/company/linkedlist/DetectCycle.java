package com.company.linkedlist;

public class DetectCycle {
    public boolean detectCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && tortoise != null) {
            if (hare == null || hare.next == null) {
                return false;
            }

            tortoise = tortoise.next;
            hare = hare.next.next;

            if (hare == tortoise) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Given a linked list. Detect any cycle/ loop in it. Return true or false
 * https://leetcode.com/problems/linked-list-cycle/
 */
