package com.company.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathSum2Test {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testPathSum(TreeNode node,int targetSum, List<List<Integer>> expectedResult) {
        List<List<Integer>> result = new PathSum2().pathSum(node, targetSum);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.right.left = new TreeNode(5);
        root1.right.right.right = new TreeNode(1);

        List<List<Integer>> listOfLists = new ArrayList<>();

        listOfLists.add(new ArrayList<>(List.of(5, 4, 11, 2)));
        listOfLists.add(new ArrayList<>(List.of(5, 8, 4, 5)));

        return Stream.of(
                Arguments.of(root1, 22, listOfLists)
        );
    }
}
