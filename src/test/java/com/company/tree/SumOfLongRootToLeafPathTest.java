package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfLongRootToLeafPathTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testSumOfLongRootToLeafPath(TreeNode node, int  expectedResult) {
        int result = new SumOfLongRootToLeafPath().sumOfLongRootToLeafPath(node);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(7);
        root1.left.right = new TreeNode(1);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(3);
        root1.left.right.left = new TreeNode(6);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);

        return Stream.of(
                Arguments.of(root1, 13),
                Arguments.of(root2, 11)
        );
    }
}
