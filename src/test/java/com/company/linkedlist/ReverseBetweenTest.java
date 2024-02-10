package com.company.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReverseBetweenTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testReverseBetween(ListNode head, int m, int n, ListNode expectedResult) {
        ListNode result = new ReverseBetween().reverseBetween(head, m, n);
        assertTrue(Helper.areLinkedListsEqual(expectedResult, result));
    }

    static Stream<Arguments> testDataProvider() {
        ListNode head = Helper.createLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode result = Helper.createLinkedList(new int[]{1, 2, 5, 4, 3, 6});

        ListNode head1 = Helper.createLinkedList(new int[]{1, 2, 3});
        ListNode result1 = Helper.createLinkedList(new int[]{3, 2, 1});

        ListNode head2 = Helper.createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode result2 = Helper.createLinkedList(new int[]{1, 5, 4, 3, 2});

        return Stream.of(
                Arguments.of(head, 3, 5, result),
                Arguments.of(new ListNode(5), 1, 1, new ListNode(5)),
                Arguments.of(null, 1, 1, null),
                Arguments.of(head1, 1, 3, result1),
                Arguments.of(head2, 2, 5, result2)
        );
    }
}
