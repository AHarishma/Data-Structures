package com.company.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PainterPartitionProblemTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testPainterPartitionProblem(int[] arr, int n, int k, int expectedResult) {
        long result = new PainterPartitionProblem().minTime(arr, n, k);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{10, 20, 30, 40}, 4, 2, 60),
                Arguments.of(new int[]{5, 10, 30, 20, 15}, 5, 3, 35),
                Arguments.of(new int[]{4, 2, 22, 8, 2, 11, 19, 13}, 8, 3, 32)
        );
    }
}
