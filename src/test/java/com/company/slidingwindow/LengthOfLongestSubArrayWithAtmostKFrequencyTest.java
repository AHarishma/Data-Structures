package com.company.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthOfLongestSubArrayWithAtmostKFrequencyTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testLengthOfLongestSubArrayWithAtmostKFrequency(int[] arr, int k, int expectedResult) {
        int result = new LengthOfLongestSubArrayWithAtmostKFrequency().maxSubarrayLength(arr, k);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2, 6),
                Arguments.of(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1, 2),
                Arguments.of(new int[]{5, 5, 5, 5, 5, 5, 5}, 4, 4),
                Arguments.of(new int[]{1, 2}, 1, 2),
                Arguments.of(new int[]{1, 2}, 2, 2),
                Arguments.of(new int[]{1, 1}, 1, 1)
        );
    }
}
