package com.company.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstIndexTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testFirstIndex(int[] arr, int target, int expectedResult) {
        int result = new FirstIndex().firstIndex(arr, target);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 3, 3}, 3, 3),
                Arguments.of(new int[]{4, 4, 4, 5, 5, 5, 5, 5, 6, 6}, 5, 3),
                Arguments.of(new int[]{-30, -30, -30, 2, 2}, -20, -1)
        );
    }
}
