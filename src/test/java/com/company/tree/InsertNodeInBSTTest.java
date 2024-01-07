package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class InsertNodeInBSTTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testInsertNodeInBST(TreeNode node, int val, TreeNode expectedResult) {
        TreeNode result = new InsertNodeInBST().insert(node, val);
        Helper.isSameTree(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);

        TreeNode result = new TreeNode(2);
        result.left = new TreeNode(1);
        result.right = new TreeNode(3);
        result.right.right = new TreeNode(6);
        result.right.right.left = new TreeNode(4);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        TreeNode result2 = new TreeNode(2);
        result2.left = new TreeNode(1);
        result2.right = new TreeNode(3);
        result2.right.right = new TreeNode(4);

        return Stream.of(
                Arguments.of(root, 4, result),
                Arguments.of(root2, 4, result2)
        );
    }
}
