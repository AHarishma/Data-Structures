package com.company.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CovidSpreadTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testCovidSpread(int[][] matrix, int expectedResult) {
        int result = new CovidSpread().covidSpread(matrix);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        int[][] matrix = new int[][]{
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        int[][] matrix1 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 2, 0}
        };

        int[][] matrix2 = new int[][]{
                {2, 1, 0, 2, 1},
                {0, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        return Stream.of(
                Arguments.of(matrix, 2),
                Arguments.of(matrix1, 0),
                Arguments.of(matrix2, -1)
        );
    }
}
