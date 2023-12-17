package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DFSTraversalTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testPreOrderTraversal(TreeNode node) {
        List<Integer> result = new DFSTraversal().preOrderTraversal(node);
        assertEquals(Arrays.asList(1, 2, 4, 5, 3, 6), result);
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testInOrderTraversal(TreeNode node) {
        List<Integer> result = new DFSTraversal().inOrderTraversal(node);
        assertEquals(Arrays.asList(4, 2, 5, 1, 3, 6), result);
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testPostOrderTraversal(TreeNode node) {
        List<Integer> result = new DFSTraversal().postOrderTraversal(node);
        assertEquals(Arrays.asList(4, 5, 2, 6, 3, 1), result);
    }

    static Stream<Arguments> testDataProvider() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        return Stream.of(
                Arguments.of(root)
        );
    }
}
