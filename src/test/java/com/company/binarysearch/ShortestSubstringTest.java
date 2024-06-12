package com.company.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestSubstringTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testShortestSubstring(String str, int expectedResult) {
        long result = new ShortestSubstring().shortestSubstring(str);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("aaaabbcbbbaccccab", 3),
                Arguments.of("aaaabbcbbb", 4),
                Arguments.of("acb", 3),
                Arguments.of("abbbbbbbbbbbbbbbbbbc", 20)
        );
    }
}
