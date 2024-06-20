package com.company.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContinuousTaskCompletionTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testContinuousTaskCompletion(int[] arr, int k, int expectedResult) {
        int result = new ContinuousTaskCompletion().getMinimumTime(arr, k);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 4, 3}, 3, 6)
        );
    }
}
