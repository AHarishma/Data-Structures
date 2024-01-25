package com.company.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightArrangementsTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testKnightArrangements(int[][] matrix, int expectedResult) {
        int result = new KnightArrangements().getNumberOfKnightArrangements(matrix);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        int[][] chessboard1 = new int[][]{
                {0, 0, 2, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 2, 0, 2, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2},
                {0, 0, 2, 0, 0}
        };
        int[][] chessboard2 = new int[][]{
                {0, 0, 2, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 2, 0, 2, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {2, 2, 2, 0, 0}
        };
        return Stream.of(
                Arguments.of(chessboard1, 120),
                Arguments.of(chessboard2, 6)
        );
    }
}
