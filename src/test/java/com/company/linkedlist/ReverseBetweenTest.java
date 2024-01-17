package com.company.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ReverseBetweenTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testReverseLinkedList(ListNode head, int m, int n, ListNode expectedResult) {
        ListNode result =  new ReverseBetween().reverseBetween(head, m, n);
        Helper.areLinkedListsEqual(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = new ListNode(1);
        result.next = new ListNode(2);
        result.next.next = new ListNode(5);
        result.next.next.next = new ListNode(4);
        result.next.next.next.next = new ListNode(3);
        result.next.next.next.next.next = new ListNode(6);

        return Stream.of(
                Arguments.of(head, 3, 5, result)
        );
    }
}
