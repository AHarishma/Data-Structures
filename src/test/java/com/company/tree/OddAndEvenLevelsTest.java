package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OddAndEvenLevelsTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testOddAndEvenLevels(TreeNode node, int expectedResult) {
        int result = new OddAndEvenLevels().solve(node);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        root1.left.left.left = new TreeNode(8);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(10);
        root2.left.right = new TreeNode(4);

        return Stream.of(
                Arguments.of(root1, 10),
                Arguments.of(root2, -7)
        );
    }
}
