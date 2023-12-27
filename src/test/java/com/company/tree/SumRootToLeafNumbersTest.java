package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumRootToLeafNumbersTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testPathSum(TreeNode node, int  expectedResult) {
        int result = new SumRootToLeafNumbers().sumNumbers(node);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(0);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(1);

        return Stream.of(
                Arguments.of(root1, 1026)
        );
    }
}
