package com.company.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FloorValueTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testFloorValue(int[] arr, int value, int expectedResult) {
        int result = new FloorValue().findFloorValue(arr, value);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 7, 10, 13, 19, 25, 30, 35}, 14, 4),
                Arguments.of(new int[]{1, 5, 7, 10, 19, 25, 30, 35}, 14, 3),
                Arguments.of(new int[]{1, 2, 3}, 3, 2),
                Arguments.of(new int[]{15, 16, 17}, 14, -1)
        );
    }
}
