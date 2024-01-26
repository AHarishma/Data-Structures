package com.company.heap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialMedianTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testSpecialMedian(int[] arr, int expectedResult) {
        int result = new SpecialMedian().solve(arr);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{4, 6, 8, 4}, 1),
                Arguments.of(new int[]{2, 7, 3, 1}, 0)
        );
    }
}
