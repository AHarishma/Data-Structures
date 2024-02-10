package com.company.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemovePairsTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testRemovePairs(String input, String expectedResult) {
        String result = new RemovePairs().removePairs(input);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("abcdeffedba", "abcba"),
                Arguments.of("abcdeffjdba", "abcdejdba"),
                Arguments.of("abcdeffedcba", ""),
                Arguments.of("abcddjhffba", "abcjhba")
        );
    }
}
