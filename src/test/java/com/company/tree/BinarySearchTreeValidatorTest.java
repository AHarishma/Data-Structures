package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeValidatorTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testBinarySearchTreeValidator(TreeNode node, boolean expectedResult) {
        boolean result = new BinarySearchTreeValidator().validateBinarySearchTree(node);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        TreeNode root3 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        return Stream.of(
                Arguments.of(root1, false),
                Arguments.of(root2, false),
                Arguments.of(root3, true)
        );
    }
}
