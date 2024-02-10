package com.company.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InfixToPostfixTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testInfixToPostfix(String expression, String expectedResult) {
        String result = new InfixToPostfix().infixToPostFix(expression);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("a+b", "ab+"),
                Arguments.of("a+(b*c)", "abc*+"),
                Arguments.of("(a*(b/c))+d", "abc/*d+"),
                Arguments.of("h^m^q^(7-4)", "hm^q^74-^")
        );
    }
}
