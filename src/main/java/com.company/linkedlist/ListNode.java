package com.company.linkedlist;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
