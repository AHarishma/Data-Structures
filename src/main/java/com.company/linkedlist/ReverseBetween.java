package com.company.linkedlist;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < m; i++) {
            prev = prev.next;
        }
        ListNode current = prev.next;
        ListNode tail = current;
        for(int i = m; i <= n; i++) {
            current.next = prev.next;
            prev.next = current;
            current = current.next;
        }
        tail.next = current;
        return dummy.next;
    }
}

/**
 * Reverse a linked list for given ranges. Left and right or start and end
 */
