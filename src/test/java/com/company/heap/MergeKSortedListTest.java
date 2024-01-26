package com.company.heap;

import com.company.linkedlist.LinkedListUtils;
import com.company.linkedlist.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MergeKSortedListTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testMergeKSortedList(ListNode[] lists, ListNode expectedResult) {
        ListNode result = new MergeKSortedList().mergeKLists(lists);
        assertTrue(LinkedListUtils.areEqual(expectedResult, result));
    }

    private static Stream<Arguments> testDataProvider() {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        int[] values = new int[]{1, 1, 2, 3, 4, 4, 5, 6};
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        ListNode[] emptyLists = new ListNode[1];
        emptyLists[0] = null;

        return Stream.of(
                Arguments.of(lists, dummy.next),
                Arguments.of(emptyLists, new ListNode(0).next)
        );
    }
}
