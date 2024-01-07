package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthSmallestElementInBSTTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testKthSmallestElementInBST(TreeNode node, int k, int expectedResult) {
        int result = new KthSmallestElementInBST().kthSmallestElementInBST(node, k);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        return Stream.of(
                Arguments.of(root, 2, 2),
                Arguments.of(root, 6, -1)
        );
    }
}
