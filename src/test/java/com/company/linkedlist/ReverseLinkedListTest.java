package com.company.linkedlist;

import com.company.bitmanipulation.UnsetBit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ReverseLinkedListTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testReverseLinkedList(ListNode head, ListNode expectedResult) {
        ListNode result = new ReverseLinkedList().reverseLinkedList(head);
        Helper.areLinkedListsEqual(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode result = new ListNode(3);
        result.next = new ListNode(2);
        result.next.next = new ListNode(1);

        return Stream.of(
                Arguments.of(head, result),
                Arguments.of(new ListNode(5), new ListNode(5))
        );
    }
}
