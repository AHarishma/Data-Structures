package com.company.linkedlist;

public class RemoveDuplicates {
    public ListNode removeDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode current = head;
        while(current != null) {
            if(prev.val != current.val) {
                prev.next = current;
                prev = current;
            }
            current = current.next;
        }
        prev.next = null;
        return dummy.next;
    }
}

/**
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */