package com.company.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CopyListWithRandomPointerTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testReorderList(NodeWithRandomPointer head, NodeWithRandomPointer expectedResult) {
        NodeWithRandomPointer result = new CopyListWithRandomPointer().copyRandomList(head);
        assertTrue(areLinkedListsEqual(expectedResult, result));
    }

    public static boolean areLinkedListsEqual(NodeWithRandomPointer list1, NodeWithRandomPointer list2) {
        NodeWithRandomPointer current1 = list1;
        NodeWithRandomPointer current2 = list2;

        while (current1 != null && current2 != null) {
            if (current1.val != current2.val) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1 == null && current2 == null;
    }

    public static NodeWithRandomPointer createLinkedList(int[][] elements) {
        NodeWithRandomPointer head = null;
        NodeWithRandomPointer current = null;
        for (int[] element : elements) {
            if (head == null) {
                head = new NodeWithRandomPointer(element[0]);
                current = head;
            } else {
                current.next = new NodeWithRandomPointer(element[0]);
                current = current.next;
            }
        }
        return head;
    }

    static Stream<Arguments> testDataProvider() {
//        NodeWithRandomPointer head = createLinkedList(new int[][]{{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}});
//        NodeWithRandomPointer result = createLinkedList(new int[][]{1, 5, 2, 4, 3});
//
        return Stream.of(
//                Arguments.of(head, result)
        );
    }
}
