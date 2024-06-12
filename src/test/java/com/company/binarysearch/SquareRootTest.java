package com.company.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareRootTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testSquareRoot(int n, double expectedResult) {
        double result = new SquareRoot().sqrt(n);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(2, 1.41421),
                Arguments.of(1, 1),
                Arguments.of(4, 2),
                Arguments.of(10, 3.16228)
        );
    }
}
