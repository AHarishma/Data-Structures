package com.company.linkedlist;

public class ReorderList {
    public ListNode reorderList(ListNode head) {
        ListNode mid = findMiddleNode(head);
        ListNode nextOfMiddle = mid.next;
        mid.next = null;
        ListNode list2 = reverseLinkedList(nextOfMiddle);
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (head != null && list2 != null) {
            current.next = head;
            head = head.next;
            current = current.next;
            current.next = list2;
            list2 = list2.next;
            current = current.next;
        }
        current.next = head;
        return dummy.next;
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (fast.next == null) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}

/**
 * https://leetcode.com/problems/reorder-list/description/
 * You are given the head of a singly linked-list. The list can be represented as:
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 */


