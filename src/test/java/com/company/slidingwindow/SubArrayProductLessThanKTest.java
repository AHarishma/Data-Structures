package com.company.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SubArrayProductLessThanKTest {
    @ParameterizedTest
    @MethodSource("testProvider")
    public void testNumSubarrayProductLessThanK(int[] nums, int k, int expectedResult) {
        int result = new SubArrayProductLessThanK().numSubarrayProductLessThanK(nums, k);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testProvider() {
        return Stream.of(
                Arguments.of(new int[]{10, 5, 2, 6}, 100, 8),
                Arguments.of(new int[]{1, 2, 3}, 0, 0)
        );
    }
}
