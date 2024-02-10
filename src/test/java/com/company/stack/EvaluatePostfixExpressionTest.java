package com.company.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvaluatePostfixExpressionTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testEvaluatePostfixExpression(String expression, int expectedResult) {
        int result = new EvaluatePostfixExpression().evaluatePostfixExpression(expression);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("21+", 3),
                Arguments.of("263/*5+", 9)
        );
    }
}
