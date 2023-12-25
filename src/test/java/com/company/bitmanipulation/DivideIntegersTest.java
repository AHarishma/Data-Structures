package com.company.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideIntegersTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testDivideIntegers(int a, int b, int expectedResult) {
        int result = new DivideIntegers().divideIntegers(a, b);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(23, 6, 3),
                Arguments.of(7, -3, -2),
                Arguments.of(-2147483648, -1, 2147483647),
                Arguments.of(-2147483648, 1, -2147483648),
                Arguments.of(2147483647, 1, 2147483647),
                Arguments.of(2147483647, 2, 1073741823)
        );
    }
}
