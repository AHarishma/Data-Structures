package com.company.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveKnightTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testKnightArrangements(int[][] matrix, int sx, int sy, int dx, int dy, int expectedResult) {
        int result = new MoveKnight().getMinimumNumberOfSteps(matrix, sx, sy, dx, dy);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        int[][] chessboard1 = new int[][]{
                {0, 2, 0, 0, 0},
                {0, 0, 0, 3, 0},
                {0, 2, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 3},
                {0, 0, 0, 0, 0}
        };
        return Stream.of(
                Arguments.of(chessboard1, 2, 1, 4, 4, 3),
                Arguments.of(chessboard1, 0, 1, 1, 3, 1)
        );
    }
}
