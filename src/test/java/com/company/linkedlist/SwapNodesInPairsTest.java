package com.company.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwapNodesInPairsTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testSwapNodesInPairs(ListNode head, ListNode expectedResult) {
        ListNode result = new SwapNodesInPairs().swapNodesInPairs(head);
        assertTrue(Helper.areLinkedListsEqual(expectedResult, result));
    }

    static Stream<Arguments> testDataProvider() {
        ListNode head = Helper.createLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode result = Helper.createLinkedList(new int[]{2, 1, 4, 3, 6, 5});

        ListNode head1 = Helper.createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = Helper.createLinkedList(new int[]{2, 1, 4, 3, 5});

        ListNode head2 = Helper.createLinkedList(new int[]{11, 12, 13, 14, 15, 16});
        ListNode result2 = Helper.createLinkedList(new int[]{12, 11, 14, 13, 16, 15});

        ListNode head3 = Helper.createLinkedList(new int[]{1});
        ListNode result3 = Helper.createLinkedList(new int[]{1});

        return Stream.of(
                Arguments.of(head, result)
//                Arguments.of(head1, result1),
//                Arguments.of(head2, result2),
//                Arguments.of(head3, result3)
        );
    }
}
