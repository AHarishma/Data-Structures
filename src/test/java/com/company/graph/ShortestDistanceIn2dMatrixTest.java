package com.company.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestDistanceIn2dMatrixTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testShortestDistance(int[][] matrix, int sx, int sy, int dx, int dy,  int expectedResult) {
        int result = new ShortestDistanceIn2dMatrix().shortestDistance(matrix, sx, sy, dx, dy);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        int[][] matrix = new int[][]{
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}
        };
        return Stream.of(
                Arguments.of(matrix, 2, 0, 2, 3, 5)
        );
    }
}
