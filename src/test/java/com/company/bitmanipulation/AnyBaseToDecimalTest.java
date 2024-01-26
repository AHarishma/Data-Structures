package com.company.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnyBaseToDecimalTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testAnyBaseToDecimal(int a, int b, int expectedResult) {
        int result = new AnyBaseToDecimal().solve(a, b);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(1010, 2, 10),
                Arguments.of(22, 3, 8)
        );
    }
}
