package com.company.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedundantBracesTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testRedundantBraces(String input, boolean expectedResult) {
        boolean result = new RedundantBraces().checkRedundantBraces(input);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("(a + b)", false),
                Arguments.of("((a + b))", true),
                Arguments.of("(a + (b * c))", false),
                Arguments.of("((a * b) + (c * d))", false),
                Arguments.of("a + (b + c)", false),
                Arguments.of("()", true)
        );
    }
}
