package com.company.linkedlist;

public class LoopLength {
    public int findLengthOfLoop(ListNode head) {
        ListNode startingNode = findStartingPointOfLoop(head);
        if (startingNode == null) {
            return 0;
        }
        ListNode current = startingNode.next;
        int length = 1;
        while (current != startingNode) {
            current = current.next;
            length++;
        }
        return length;
    }

    private ListNode findStartingPointOfLoop(ListNode head) {
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
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}

/**
 * https://www.geeksforgeeks.org/problems/find-length-of-loop/1
 *
 * Given a linked list of size N.
 * The task is to complete the function countNodesinLoop() that checks whether a given Linked List contains a loop or not
 * and if the loop is present then return the count of nodes in a loop or else return 0.
 * C is the position of the node to which the last node is connected. If it is 0 then no loop.
 */
