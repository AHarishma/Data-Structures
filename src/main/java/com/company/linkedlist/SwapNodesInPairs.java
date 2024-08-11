package com.company.linkedlist;

public class SwapNodesInPairs {
    public ListNode swapNodesInPairs(ListNode head) {
        if(head == null && head.next == null) {
            return head;
        }
        ListNode oddDummy = new ListNode(-1);
        ListNode oddTail = oddDummy;
        ListNode evenDummy = new ListNode(-1);
        ListNode evenTail = evenDummy;
        ListNode current = head;
        while(current != null) {
            oddTail.next = current;
            oddTail = oddTail.next;
            oddTail.next = null;
            current = current.next;
            if(current != null) {
                evenTail.next = current;
                evenTail = evenTail.next;
                evenTail.next = null;
                current = current.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode odd = oddDummy.next;
        ListNode even = evenDummy.next;
        while(odd != null && even != null) {
            tail.next = even;
            tail = tail.next;
            tail.next = odd;
            tail = tail.next;
        }
        tail.next = odd;
        return dummy.next;
    }
}

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * 1 --> 2 --> 3 --> 4 --> 5
 * -1 --> 1 --> 3 ---> 5
 * -1 --> 2 ---> 4
 */
