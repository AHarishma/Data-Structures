package com.company.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoopLengthTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testDetectCycle(ListNode head, int expectedResult) {
        int result = new LoopLength().findLengthOfLoop(head);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(3);
        head1.next.next.next.next.next = new ListNode(6);

        return Stream.of(
                Arguments.of(head, 4),
                Arguments.of(head1, 0)
        );
    }
}
