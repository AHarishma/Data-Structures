package com.company.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IslandCountIn2dMatrixTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testIslandCountIn2dMatrix(int[][] matrix, int expectedResult) {
        int result = new IslandCountIn2dMatrix().countIsland(matrix);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        int[][] matrix = new int[][]{
                {1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 1, 1, 1}
        };
        return Stream.of(
                Arguments.of(matrix, 5)
        );
    }
}
