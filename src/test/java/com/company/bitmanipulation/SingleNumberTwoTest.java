package com.company.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleNumberTwoTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testSingleNumber(int[] arr, int expectedResult) {
        int result =  new SingleNumberTwo().singleNumber(arr);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1,1,3,5,1,5,5}, 3),
                Arguments.of(new int[]{1,1,6,6,1,6,9}, 9)
        );
    }
}
