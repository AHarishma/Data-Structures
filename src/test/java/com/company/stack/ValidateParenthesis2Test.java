package com.company.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateParenthesis2Test {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testValidateParenthesis2(String input, boolean expectedResult) {
        boolean result =  new ValidateParenthesis2().validateParenthesis(input);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("((ab))[]", true),
                Arguments.of("{([]})", false),
                Arguments.of("({[ab", false),
                Arguments.of("a)()", false),
                Arguments.of("){", false),
                Arguments.of("(){[]}", true)
        );
    }
}
