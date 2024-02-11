package com.company.linkedlist;

public class PairwiseSwapNodes {
    public ListNode pairwiseSwapNodes(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null && current.next != null) {
           int temp = current.val;
           current.val = current.next.val;
           current.next.val = temp;
           current = current.next.next;
        }
        return head;
    }
}
