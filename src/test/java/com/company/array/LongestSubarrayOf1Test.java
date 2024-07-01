package com.company.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubarrayOf1Test {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testLongestSubarrayOf1(int[] arr, int expectedResult) {
        int result = new LongestSubarrayOf1().longestSubarray(arr);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 0, 1}, 3),
                Arguments.of(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}, 5),
                Arguments.of(new int[]{1, 1, 1}, 2)
        );
    }
}
