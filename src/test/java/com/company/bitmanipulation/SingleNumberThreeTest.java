package com.company.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleNumberThreeTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testSingleNumber(int[] arr, int[] expectedResult) {
        int[] result = new SingleNumberThree().singleNumber(arr);
        assertArrayEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 3, 5, 2, 2}, new int[]{5, 3}),
                Arguments.of(new int[]{5, 7, 5, 7, 8, 6}, new int[]{8, 6}),
                Arguments.of(new int[]{-1, 0}, new int[]{-1, 0})
        );
    }
}
