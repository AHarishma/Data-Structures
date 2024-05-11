package com.company.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SlidingWindowMaximumDequeTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testSlidingWindowMaximum(int[] arr, int k, int[] expectedResult) {
        int[] result = new SlidingWindowMaximumDeque().slidingWindowMaximum(arr, k);
        assertArrayEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 5, 4}, 3, new int[]{5, 5}),
                Arguments.of(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7})
        );
    }
}
