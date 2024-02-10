package com.company.linkedlist;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReverseLinkedListTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testReverseLinkedList(ListNode head, ListNode expectedResult) {
        ListNode result = new ReverseLinkedList().reverseLinkedList(head);
        assertTrue(Helper.areLinkedListsEqual(expectedResult, result));
    }

    static Stream<Arguments> testDataProvider() {
        ListNode head = Helper.createLinkedList(new int[]{1, 2, 3});
        ListNode result = Helper.createLinkedList(new int[]{3, 2, 1});

        return Stream.of(
                Arguments.of(head, result),
                Arguments.of(new ListNode(5), new ListNode(5))
        );
    }
}
