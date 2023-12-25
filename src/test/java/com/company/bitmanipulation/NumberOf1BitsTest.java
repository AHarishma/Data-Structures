package com.company.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOf1BitsTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testNumberOf1Bits(int num, int expectedResult) {
        int result = new NumberOf1Bits().numSetBits(num);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(11, 3),
                Arguments.of(6, 2)
        );
    }
}
