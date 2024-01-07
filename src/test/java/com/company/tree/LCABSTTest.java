package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LCABSTTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testLowestCommonAncestorBST(TreeNode node, TreeNode p, TreeNode q, TreeNode expectedResult) {
        TreeNode result = new LCABST().lowestCommonAncestor(node, p, q);
        Helper.isSameTree(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        return Stream.of(
                Arguments.of(root, root.left, root.right, root),
                Arguments.of(root, root.left, root.left.right, root.left)
        );
    }
}
