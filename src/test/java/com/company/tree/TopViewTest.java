package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopViewTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testTopView(TreeNode node, List<Integer> expectedResult) {
        List<Integer> result = new TopView().topView(node);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(10);

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(2);
        root1.right.left.left = new TreeNode(-1);

        return Stream.of(
                Arguments.of(root, Arrays.asList(4, 2, 1, 9, 6)),
                Arguments.of(root1, Arrays.asList(-1, 1, 3))
        );
    }
}
