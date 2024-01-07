package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DeserializeBinaryTreeTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testDeserializeBinaryTree(int[] arr, TreeNode expectedResult) {
        TreeNode result = new DeserializeBinaryTree().solve(arr);
        Helper.isSameTree(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.right = new TreeNode(6);

        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1}, root1),
                Arguments.of(new int[]{1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1}, root2)
        );
    }
}
