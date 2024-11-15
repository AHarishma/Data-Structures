package com.company.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumSizeSubarraySumTest {
    @ParameterizedTest
    @MethodSource("testProvider")
    public void testMinSubArrayLen(int[] nums, int k, int expectedResult) {
        int result = new MinimumSizeSubarraySum().minSubArrayLen(k, nums);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1, 2, 4, 3}, 7, 2),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 11, 0),
                Arguments.of(new int[]{1, 4, 4}, 4, 1)
        );
    }
}
