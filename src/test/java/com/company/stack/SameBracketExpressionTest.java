package com.company.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SameBracketExpressionTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testSameBracketExpression(String expression1, String expression2, boolean expectedResult) {
        boolean result = new SameBracketExpression().areSameExpressions(expression1, expression2);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("-(a+(b+c))", "-a-(b+c)", true),
                Arguments.of("-(-(a+(b+c)))", "-(-(-(a+(b+c))))", false)
        );
    }
}
