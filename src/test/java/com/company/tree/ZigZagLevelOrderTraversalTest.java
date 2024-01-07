package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ZigZagLevelOrderTraversalTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testZigZagLevelOrderTraversal(TreeNode node, int[][] expectedResult) {
        int[][] result = new ZigZagLevelOrderTraversal().zigZagLevelOrderTraversal(node);
        assertArrayEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        return Stream.of(
                Arguments.of(root, new int[][]{{3}, {20, 9}, {15, 7}})
        );
    }
}
