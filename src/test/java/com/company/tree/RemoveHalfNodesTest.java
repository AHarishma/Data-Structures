package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RemoveHalfNodesTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testRemoveHalfNodes(TreeNode node, TreeNode expectedResult) {
        TreeNode result = new RemoveHalfNodes().removeHalfNodes(node);
        Helper.isSameTree(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(5);
        root1.left.right = new TreeNode(9);
        root1.right.right = new TreeNode(1);
        root1.left.right.left = new TreeNode(11);
        root1.left.right.right = new TreeNode(4);

        TreeNode result1 = new TreeNode(2);
        result1.left = new TreeNode(9);
        result1.right = new TreeNode(1);
        result1.left.left = new TreeNode(11);
        result1.left.right = new TreeNode(4);


        TreeNode root2 = new TreeNode(7);
        root2.left = new TreeNode(7);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(2);

        TreeNode result2 = new TreeNode(7);
        result2.left = new TreeNode(2);
        result2.right = new TreeNode(8);


        return Stream.of(
                Arguments.of(root1, result1),
                Arguments.of(root2, result2)
        );
    }
}
