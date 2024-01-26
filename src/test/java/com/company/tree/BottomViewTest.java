package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BottomViewTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testBottomView(Node node, List<Integer> expectedResult) {
        List<Integer> result = new BottomView().bottomView(node);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(6);
        root.left.right.right = new Node(9);
        root.right.left.left = new Node(10);

        Node root1 = new Node(1);
        root1.right = new Node(3);
        root1.right.left = new Node(2);
        root1.right.left.left = new Node(-1);

        return Stream.of(
                Arguments.of(root, Arrays.asList(4, 10, 7, 9, 6)),
                Arguments.of(root1, Arrays.asList(-1, 2, 3))
        );
    }
}
