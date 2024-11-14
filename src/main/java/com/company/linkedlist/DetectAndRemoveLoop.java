package com.company.linkedlist;

public class DetectAndRemoveLoop {

    public void removeLoop(ListNode head) {
        ListNode node = findLastNodeOfLoop(head);
        if (node != null) {
            node.next = null;
        }
    }

    private ListNode findLastNodeOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }
        ListNode prev = null;
        slow = head;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        if (prev == null) {
            fast = slow.next;
            while (fast != slow) {
                prev = fast;
                fast = fast.next;
            }
        }

        return prev;
    }
}

/**
 * https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
 * <p>
 * Given a linked list of N nodes such that it may contain a loop.
 * <p>
 * A loop here means that the last node of the link list is connected to the node at position X(1-based index).
 * If the link list does not have any loop, X=0.
 * <p>
 * Remove the loop from the linked list, if it is present,
 * i.e. unlink the last node which is forming the loop.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * N = 3
 * value[] = {1,3,4}
 * X = 2
 * Output: 1
 * Explanation: The link list looks like
 * 1 -> 3 -> 4
 *      |    |
 *      |----|
 * A loop is present. If you remove it
 * successfully, the answer will be 1.
 */
