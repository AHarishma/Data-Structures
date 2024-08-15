package com.company.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeListTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testReorderList(ListNode head, boolean expectedResult) {
        boolean result = new PalindromeList().isPalindrome(head);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        ListNode head = Helper.createLinkedList(new int[]{1, 2, 2, 1});
        ListNode head1 = Helper.createLinkedList(new int[]{1, 2, 3, 2, 1});
        ListNode head2 = Helper.createLinkedList(new int[]{3});
        ListNode head3 = Helper.createLinkedList(new int[]{1, 2, 9, 7, 1});
        return Stream.of(
                Arguments.of(head, true),
                Arguments.of(head1, true),
                Arguments.of(head2, true),
                Arguments.of(head3, false)
        );
    }
}
