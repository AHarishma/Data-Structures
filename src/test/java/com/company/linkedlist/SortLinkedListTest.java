package com.company.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortLinkedListTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testSortLinkedList(ListNode head, ListNode expectedResult) {
        ListNode result = new SortLinkedList().sortLinkedList(head);
        assertTrue(Helper.areLinkedListsEqual(expectedResult, result));
    }

    static Stream<Arguments> testDataProvider() {
        ListNode head = Helper.createLinkedList(new int[]{5, 4, 3, 2, 1});
        ListNode result = Helper.createLinkedList(new int[]{1, 2, 3, 4, 5});

        ListNode head1 = Helper.createLinkedList(new int[]{4, 7, 2, 3});
        ListNode result1 = Helper.createLinkedList(new int[]{2, 3, 4, 7});

        ListNode head2 = Helper.createLinkedList(new int[]{10, 8, 1, 2, 6});
        ListNode result2 = Helper.createLinkedList(new int[]{1, 2, 6, 8, 10});

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
