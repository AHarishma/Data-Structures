package com.company.linkedlist;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NodeWithRandomPointer {
    public int val;
    public NodeWithRandomPointer next;
    public NodeWithRandomPointer random;

    public NodeWithRandomPointer(int val) {
        this.val = val;
    }
}
