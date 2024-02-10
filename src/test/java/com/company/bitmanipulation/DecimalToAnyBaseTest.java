package com.company.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecimalToAnyBaseTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testDecimalToAnyBase(int a, int b, int expectedResult) {
        int result = new DecimalToAnyBase().decimalToAnyBase(a, b);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(4, 3, 11),
                Arguments.of(4, 2, 100)
        );
    }
}
