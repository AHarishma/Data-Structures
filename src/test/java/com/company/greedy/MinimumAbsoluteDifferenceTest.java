package com.company.greedy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumAbsoluteDifferenceTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testMinimumAbsoluteDifference(int[] arr, int expectedResult) {
        int result = new MinimumAbsoluteDifference().findX(arr);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 11, 12}, 7));
    }
}
