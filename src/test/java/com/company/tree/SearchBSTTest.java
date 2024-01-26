package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SearchBSTTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testSearchBST(TreeNode node, int val, TreeNode expectedResult) {
        TreeNode result = new SearchBST().searchBST(node, val);
        Helper.isSameTree(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = new TreeNode(2);
        result.left = new TreeNode(7);
        result.right = new TreeNode(3);

        return Stream.of(
                Arguments.of(root, 2, result),
                Arguments.of(root, 5, null)
        );
    }
}
