package com.company.tree;

import com.sun.source.tree.Tree;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsomorphicTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testIsIsomorphic(TreeNode node1, TreeNode node2, boolean expectedResult) {
        boolean result = new Isomorphic().isIsomorphic(node1, node2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(4);

        return Stream.of(
                Arguments.of(root1, root2, true)
        );
    }
}
