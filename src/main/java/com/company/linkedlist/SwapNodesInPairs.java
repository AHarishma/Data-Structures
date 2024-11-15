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
            current = current.next;
            oddTail.next = null;
            if(current != null) {
                evenTail.next = current;
                evenTail = evenTail.next;
                current = current.next;
                evenTail.next = null;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode odd = oddDummy.next;
        ListNode even = evenDummy.next;
        while(odd != null && even != null) {
            tail.next = even;
            even = even.next;
            tail = tail.next;
            tail.next = odd;
            odd = odd.next;
            tail = tail.next;
        }
        tail.next = odd;
        return dummy.next;
    }
}

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * Example 1:
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 *
 * Input: head = []
 * Output: []
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 * 1 --> 2 --> 3 --> 4 --> 5
 * -1 --> 1 --> 3 ---> 5
 * -1 --> 2 ---> 4
 */
