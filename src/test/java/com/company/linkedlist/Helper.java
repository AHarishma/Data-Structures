package com.company.linkedlist;

public class Helper {
    public static ListNode createLinkedList(int[] elements) {
        ListNode head = null;
        ListNode current = null;
        for (int element : elements) {
            if (head == null) {
                head = new ListNode(element);
                current = head;
            } else {
                current.next = new ListNode(element);
                current = current.next;
            }
        }
        return head;
    }

    public static boolean areLinkedListsEqual(ListNode list1, ListNode list2) {
        ListNode current1 = list1;
        ListNode current2 = list2;

        while (current1 != null && current2 != null) {
            if (current1.val != current2.val) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1 == null && current2 == null;
    }
}
