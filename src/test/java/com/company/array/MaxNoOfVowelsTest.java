package com.company.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxNoOfVowelsTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testMaxNoOfVowelsTest(String s, int k, int expectedResult) {
        int result = new MaxNoOfVowels().maxVowels(s, k);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("abciiidef", 3, 3),
                Arguments.of("aeiou", 2, 2),
                Arguments.of("leetcode", 3, 2)
        );
    }
}
