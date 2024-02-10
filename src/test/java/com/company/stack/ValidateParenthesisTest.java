package com.company.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateParenthesisTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testValidateParenthesis(String input, boolean expectedResult) {
        boolean result =  new ValidateParenthesis().validateParenthesis(input);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("(())()", true),
                Arguments.of("(((()", false),
                Arguments.of("(()(()", false),
                Arguments.of(")()", false),
                Arguments.of("))", false),
                Arguments.of("()", true)
        );
    }
}
