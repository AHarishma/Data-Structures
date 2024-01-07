package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiameterOfTreeTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testDiameterOfTree(TreeNode node, int expectedResult) {
        int result = new DiameterOfTree().diameter(node);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(20);
        root1.right = new TreeNode(30);
        root1.left.left = new TreeNode(40);
        root1.left.right = new TreeNode(60);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        return Stream.of(
                Arguments.of(root1, 4),
                Arguments.of(root2, 3)
        );
    }
}
