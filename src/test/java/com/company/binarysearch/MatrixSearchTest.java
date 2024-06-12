package com.company.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MatrixSearchTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testSearchMatrix(int[][] matrix, int target, int[] expectedResult) {
        int[] result = new MatrixSearch().searchMatrix(matrix, target);
        assertArrayEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {1, 3, 4, 8},
                        {9, 10, 15, 18},
                        {20, 27, 30, 40},
                        {46, 50, 90, 100}
                }, 90, new int[]{3, 2}),
                Arguments.of(new int[][]{
                        {0, 1, 2, 3},
                        {4, 5, 6, 7},
                        {8, 9, 10, 11},
                        {12, 13, 14, 15}
                }, 11, new int[]{2, 3}),
                Arguments.of(new int[][]{
                        {0, 1, 2, 3, 4},
                        {5, 6, 7, 8, 9}
                }, 10, new int[]{-1, -1})
        );
    }
}
