package com.company.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReorderListTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testReorderList(ListNode head, ListNode expectedResult) {
        ListNode result = new ReorderList().reorderList(head);
        assertTrue(Helper.areLinkedListsEqual(expectedResult, result));
    }

    static Stream<Arguments> testDataProvider() {
        ListNode head = Helper.createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode result = Helper.createLinkedList(new int[]{1, 5, 2, 4, 3});

        ListNode head1 = Helper.createLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode result1 = Helper.createLinkedList(new int[]{1, 6, 2, 5, 3, 4});

        ListNode head2 = Helper.createLinkedList(new int[]{12, 17, 10});
        ListNode result2 = Helper.createLinkedList(new int[]{12, 10, 17});

        ListNode head3 = Helper.createLinkedList(new int[]{1});
        ListNode result3 = Helper.createLinkedList(new int[]{1});

        return Stream.of(
                Arguments.of(head, result),
                Arguments.of(head1, result1),
                Arguments.of(head2, result2),
                Arguments.of(head3, result3)
        );
    }
}
