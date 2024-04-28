package com.company.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MergeTwoSortedListTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testMergeTwoSortedList(ListNode list1, ListNode list2, ListNode expectedResult) {
        ListNode result = new MergeTwoSortedList().mergeTwoLists(list1, list2);
        assertTrue(Helper.areLinkedListsEqual(expectedResult, result));
    }

    static Stream<Arguments> testDataProvider() {
        ListNode list11 = Helper.createLinkedList(new int[]{1, 2, 4});
        ListNode list21 = Helper.createLinkedList(new int[]{1, 3, 4});
        ListNode result1 = Helper.createLinkedList(new int[]{1, 1, 2, 3, 4, 4});

        ListNode list12 = Helper.createLinkedList(new int[]{});
        ListNode list22 = Helper.createLinkedList(new int[]{});
        ListNode result2 = Helper.createLinkedList(new int[]{});

        ListNode list13 = Helper.createLinkedList(new int[]{});
        ListNode list23 = Helper.createLinkedList(new int[]{0});
        ListNode result3 = Helper.createLinkedList(new int[]{0});

        return Stream.of(
                Arguments.of(list11, list21, result1),
                Arguments.of(list12, list22, result2),
                Arguments.of(list13, list23, result3)
        );
    }
}
