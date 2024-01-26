package com.company.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxAndValueTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testMaxAndValue(int[] arr, int expectedResult) {
        int result = new MaxAndValue().findMaxAndValue(arr);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{26, 13, 23, 28, 27, 7, 25}, 26)
        );
    }
}
