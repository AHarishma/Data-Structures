package com.company.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoesSubArrayHavingSumEqualToKTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testNoOfSubArrayEqualToK(int[] arr, int k, boolean expectedResult) {
        boolean result = new DoesSubArrayHavingSumEqualToK().doesSubArraysHavingSumEqualToK(arr, k);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 7, true),
                Arguments.of(new int[]{9, 4, 20, 3, 10, 5}, 33, true),
                Arguments.of(new int[]{10, 2, -2, -20, 10}, -10, true),
                Arguments.of(new int[]{1, 2}, 4, false)
        );
    }
}
