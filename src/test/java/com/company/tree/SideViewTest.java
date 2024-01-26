package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SideViewTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testLeftSideView(TreeNode node) {
        List<Integer> result = new SideView().leftSideView(node);
        assertEquals(Arrays.asList(1, 2, 4, 9), result);
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testRightSideView(TreeNode node) {
        List<Integer> result = new SideView().rightSideView(node);
        assertEquals(Arrays.asList(1, 3, 6, 10), result);
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

        return Stream.of(
                Arguments.of(root)
        );
    }
}
