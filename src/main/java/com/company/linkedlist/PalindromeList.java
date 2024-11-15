package com.company.linkedlist;

public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMiddleNode(head);
        ListNode nextOfMiddle = mid.next;
        mid.next = null;
        ListNode list2 = reverseLinkedList(nextOfMiddle);
        while (head != null && list2 != null) {
            if (head.val != list2.val) {
                return false;
            }
            head = head.next;
            list2 = list2.next;
        }
        return true;
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
 * https://leetcode.com/problems/palindrome-linked-list/description/
 * <p>
 * Given the head of a singly linked list, return true if it is a
 * palindrome
 * or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 * <p>
 * <p>
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
