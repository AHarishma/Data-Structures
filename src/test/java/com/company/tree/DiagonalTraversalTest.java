package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiagonalTraversalTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testDiagonalTraversal(TreeNode node, List<Integer> expectedResult) {
        List<Integer> result = new DiagonalTraversal().diagonal(node);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(10);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(6);
        root1.right.right = new TreeNode(14);
        root1.right.right.left = new TreeNode(13);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);

        return Stream.of(
                Arguments.of(root1, Arrays.asList(8, 10, 14, 3, 6, 7, 13, 1, 4))
        );
    }
}
