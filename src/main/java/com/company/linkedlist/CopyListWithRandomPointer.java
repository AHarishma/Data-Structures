package com.company.linkedlist;

public class CopyListWithRandomPointer {
    public NodeWithRandomPointer copyRandomList(NodeWithRandomPointer head) {
        NodeWithRandomPointer current1 = head;
        while (current1 != null) {
            NodeWithRandomPointer nextNode = current1.next;
            current1.next = new NodeWithRandomPointer(current1.val, current1.next, null);
            current1 = nextNode;
        }
        NodeWithRandomPointer current2 = head;
        while (current2 != null) {
            current2.next.random = current2.random.next;
        }
        NodeWithRandomPointer dummy1 = new NodeWithRandomPointer(-1);
        NodeWithRandomPointer tail1 = dummy1;
        NodeWithRandomPointer dummy2 = new NodeWithRandomPointer(-1);
        NodeWithRandomPointer tail2 = dummy2;
        NodeWithRandomPointer current3 = head;
        while (current3 != null) {
            tail1.next = current3;
            current3 = current3.next;
            tail1 = tail1.next;
            tail1.next = null;
            if (current3 != null) {
                tail2.next = current3;
                current3 = current3.next;
                tail2 = tail2.next;
                tail2.next = null;
            }
        }
        return dummy2.next;
    }
}
/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 * <p>
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 * <p>
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * <p>
 * Return the head of the copied linked list.
 * <p>
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 * <p>
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 1000
 * -104 <= Node.val <= 104
 * Node.random is null or is pointing to some node in the linked list.
 */