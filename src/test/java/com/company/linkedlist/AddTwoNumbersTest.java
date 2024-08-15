package com.company.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddTwoNumbersTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testAddTwoNumbers(ListNode l1, ListNode l2, ListNode expectedResult) {
        ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);
        assertTrue(Helper.areLinkedListsEqual(expectedResult, result));
    }

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(Helper.createLinkedList(new int[]{2, 4, 3}), Helper.createLinkedList(new int[]{5, 6, 4}), Helper.createLinkedList(new int[]{7, 0, 8})),
                Arguments.of(Helper.createLinkedList(new int[]{2, 4, 3}), Helper.createLinkedList(new int[]{5, 6, 9}), Helper.createLinkedList(new int[]{7, 0, 3, 1}))
        );
    }
}
