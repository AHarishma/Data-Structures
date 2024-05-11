package com.company.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZeroOneKnapsackTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testKnapsack(int W, int wt[], int val[], int expectedResult) {
        int result = new ZeroOneKnapsack().knapsack(W, wt, val);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(50, new int[]{10, 20, 30}, new int[]{60, 100, 120}, 220),
                Arguments.of(5, new int[]{1, 2, 3}, new int[]{4, 5, 6}, 11),
                Arguments.of(7, new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}, 9)
        );
    }
}
