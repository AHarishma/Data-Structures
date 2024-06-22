package com.company.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMedianTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testFindMedian(int[] arr1, int[] arr2, int expectedResult) {
        int result = new FindMedian().findMedian(arr1, arr2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{1, 2, 4, 5, 7}, 4),
                Arguments.of(new int[]{5, 7, 12, 15, 56, 78}, new int[]{}, 13),
                Arguments.of(new int[]{1, 6, 9, 15, 19, 24, 29, 30}, new int[]{2, 4, 8, 11, 13, 20, 21}, 13),
                Arguments.of(new int[]{1, 6, 9, 15, 12, 19, 24, 29, 30}, new int[]{2, 4, 8, 11, 13, 20, 21}, 12)
        );
    }
}
