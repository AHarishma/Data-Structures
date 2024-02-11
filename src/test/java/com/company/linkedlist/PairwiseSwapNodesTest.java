package com.company.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PairwiseSwapNodesTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testPairwiseSwapNodes(ListNode head, ListNode expectedResult) {
        ListNode result = new PairwiseSwapNodes().pairwiseSwapNodes(head);
        assertTrue(Helper.areLinkedListsEqual(expectedResult, result));
    }

    static Stream<Arguments> testDataProvider() {
        ListNode head1 = Helper.createLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode result1 = Helper.createLinkedList(new int[]{2, 1, 4, 3, 6, 5});
        ListNode head2 = Helper.createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode result2 = Helper.createLinkedList(new int[]{2, 1, 4, 3, 5});

        return Stream.of(
                Arguments.of(head1, result1),
                Arguments.of(head2, result2)
        );
    }
}
