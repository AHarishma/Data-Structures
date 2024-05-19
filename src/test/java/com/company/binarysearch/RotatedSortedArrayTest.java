package com.company.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotatedSortedArrayTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testRotatedSortedArray(int[] arr, int target, boolean expectedResult) {
        boolean result = new RotatedSortedArray().searchInRotatedSortedArray(arr, target);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 19, 25, 30, 35, 1, 5, 7, 10}, 25, true),
                Arguments.of(new int[]{1, 5, 7, 10, 13, 19, 25, 30, 35}, 45, false),
                Arguments.of(new int[]{1, 5, 7, 10}, 10, true)
        );
    }
}
