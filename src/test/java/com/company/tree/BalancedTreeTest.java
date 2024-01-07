package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalancedTreeTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testIsBalancedTree(TreeNode node, boolean expectedResult) {
        boolean result = new BalancedTree().isBalanced(node);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(10);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        return Stream.of(
                Arguments.of(root1, false),
                Arguments.of(root2, true)
        );
    }
}
