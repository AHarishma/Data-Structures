package com.company.bitmanipulation;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumXORValueTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testMinimumXorValue(int[] arr, int expectedResult) {
        int result = new MinimumXORValue().findMinimumXORValue(arr);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{13,5,11,1}, 4)
        );
    }
}

