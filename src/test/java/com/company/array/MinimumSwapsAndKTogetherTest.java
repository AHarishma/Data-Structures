package com.company.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumSwapsAndKTogetherTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testMinimumSwapsAndKTogetherTest(int[] arr, int n, int k, int expectedResult) {
        int result = new MinimumSwapsAndKTogether().minSwap(arr, n, k);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 9, 5, 8, 7, 4}, 7, 6, 2),
                Arguments.of(new int[]{20, 12, 17}, 3, 6, 0),
                Arguments.of(new int[]{10, 12, 20, 20, 5, 19, 19, 12, 1, 20, 1}, 11, 1, 1)
        );
    }
}
