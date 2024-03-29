package com.company.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleNumberTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testSingleNumber(int[] arr, int expectedResult) {
        int result =  new SingleNumber().singleNumber(arr);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1,1,3,5,6,5,6}, 3),
                Arguments.of(new int[]{1,1,5,6,5,6,9}, 9)
        );
    }
}
