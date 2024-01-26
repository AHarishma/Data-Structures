package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IterativeTraversalTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testInOrderIterativeTraversal(TreeNode node) {
        List<Integer> result = new IterativeTraversal().inOrder(node);
        assertEquals(Arrays.asList(4, 2, 5, 1, 3), result);
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testPreOrderIterativeTraversal(TreeNode node) {
        List<Integer> result = new IterativeTraversal().preOrder(node);
        assertEquals(Arrays.asList(1, 2, 4, 5, 3), result);
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testPostOrderIterativeTraversal(TreeNode node) {
        List<Integer> result = new IterativeTraversal().postOrder(node);
        assertEquals(Arrays.asList(4, 5, 2, 3, 1), result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        return Stream.of(
                Arguments.of(root1)
        );
    }
}
