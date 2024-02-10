package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MorrisInorderTraversalTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testMorrisInorderTraversal(TreeNode node) {
        List<Integer> result = new MorrisInorderTraversal().morrisInorderTraversal(node);
        assertEquals(Arrays.asList(4, 2, 5, 1, 3, 6), result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        return Stream.of(
                Arguments.of(root)
        );
    }
}
