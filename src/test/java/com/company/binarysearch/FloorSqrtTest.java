package com.company.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FloorSqrtTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testFloorSqrt(int n, int expectedResult) {
        long result = new FloorSqrt().floorSqrt(n);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(9, 3),
                Arguments.of(1, 1),
                Arguments.of(4, 2),
                Arguments.of(10, 3)
        );
    }
}
