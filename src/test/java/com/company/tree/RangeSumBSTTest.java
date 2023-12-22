package com.company.tree;

import com.company.bitmanipulation.UnsetBit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangeSumBSTTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testRangeSumBSTTree(TreeNode node, int low, int high, int expectedResult) {
        int result =  new RangeSumOfBST().rangeSumBST(node, low, high);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);

        return Stream.of(
                Arguments.of(root, 7, 15, 32)
        );
    }
}
