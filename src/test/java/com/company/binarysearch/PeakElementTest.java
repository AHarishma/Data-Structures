package com.company.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeakElementTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testPeakElement(int[] arr, int expectedResult) {
        int result = new PeakElement().peakElement(arr);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 7, 6, 5}, 7),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 5),
                Arguments.of(new int[]{1, 3, 5, 4, 2}, 5),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, 5)
        );
    }
}
