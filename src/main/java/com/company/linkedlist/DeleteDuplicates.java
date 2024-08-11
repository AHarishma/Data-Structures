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
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * Example 1:
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 *
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 * -1
 * |
 * 1, 2, 2, 3
 * t     p  c
 */
