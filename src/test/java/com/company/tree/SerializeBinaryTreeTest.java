package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SerializeBinaryTreeTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testSerializeBinaryTree(TreeNode node, int[] expectedResult) {
        int[] result = new SerializeBinaryTree().serializeBinaryTree(node);
        assertArrayEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
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
                Arguments.of(root1, new int[]{1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1}),
                Arguments.of(root2, new int[]{1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1})
        );
    }
}
