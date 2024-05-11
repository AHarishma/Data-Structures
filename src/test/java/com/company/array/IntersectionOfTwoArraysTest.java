package com.company.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class IntersectionOfTwoArraysTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testIntersectionOfTwoArrays(int[] arr1, int[] arr2, int[] expectedResult) {
        int[] result = new IntersectionOfTwoArrays().intersection(arr1, arr2);
        assertArrayEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2}),
                Arguments.of(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{4, 9})
        );
    }
}
