package com.company.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NearestHospitalDistanceTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testNearestHospitalDistance(int[][] matrix, int[][] expectedResult) {
        int[][] result = new NearestHospitalDistance().nearestHospital(matrix);
        assertArrayEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        int[][] matrix = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };

        int[][] result = new int[][]{
                {3, 2, 3, 3, 2, 3},
                {2, 1, 2, 2, 1, 2},
                {1, 0, 1, 1, 0, 1},
                {2, 1, 2, 1, 1, 2},
                {3, 2, 1, 0, 1, 2},
                {4, 3, 2, 1, 2, 3}
        };
        return Stream.of(
                Arguments.of(matrix, result)
        );
    }
}
