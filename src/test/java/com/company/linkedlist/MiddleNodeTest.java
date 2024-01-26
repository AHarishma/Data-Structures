package com.company.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiddleNodeTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testMiddleNode(ListNode head, ListNode expectedResult) {
        ListNode result = new MiddleNode().middleNode(head);
        Helper.areLinkedListsEqual(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        ListNode head = Helper.createLinkedList(new int[]{1, 2, 3});

        ListNode head1 = Helper.createLinkedList(new int[]{1, 2});

        ListNode head2 = Helper.createLinkedList(new int[]{1, 2, 3, 4});

        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(head, head.next),
                Arguments.of(head1, head1.next),
                Arguments.of(head2, head2.next.next)
        );
    }
}
