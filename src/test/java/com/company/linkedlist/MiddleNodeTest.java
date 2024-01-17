package com.company.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiddleNodeTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testReverseLinkedList(ListNode head, int expectedResult) {
        int result =  new MiddleNode().findMiddleNode(head);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);


        return Stream.of(
                Arguments.of(null, -1),
                Arguments.of(head, 2),
                Arguments.of(head1, 2),
                Arguments.of(head2, 3)
        );
    }
}
