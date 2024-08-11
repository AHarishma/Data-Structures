package com.company.linkedlist;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        ListNode tail = dummy;
        ListNode current = head;
        ListNode prev = dummy;
        while (current != null) {
            boolean condition = prev.val != current.val;
            if (current.next != null) {
                condition = condition && current.val != current.next.val;
            }
            if (condition) {
                tail.next = current;
                tail = current;
            }
            prev = current;
            current = current.next;
        }
        tail.next = null;
        return dummy.next;
    }
}

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 * <p>
 * -1
 * |
 * 1, 2, 2, 3
 * t     p  c
 */
