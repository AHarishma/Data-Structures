package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsValidBstInConstantSpaceTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testIsValidBST(TreeNode node, boolean expectedResult) {
        boolean result = new IsValidBstInConstantSpace().isValidBst(node);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(3);

        TreeNode root2 = new TreeNode(4);
        root2.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);

        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(4);
        root3.right.left = new TreeNode(3);
        root3.right.right = new TreeNode(6);

        return Stream.of(
                Arguments.of(root, true),
                Arguments.of(root1, false),
                Arguments.of(root2, false),
                Arguments.of(root3, false)
        );
    }
}
