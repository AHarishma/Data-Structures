package com.company.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndexOfFirstOccurrenceInStringTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testIndexOfFirstOccurrenceInString(String haystack, String needle, int expectedResult) {
        int result = new IndexOfFirstOccurrenceInString().strStr(haystack, needle);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("leetcode", "leeto", -1),
                Arguments.of("sadbutsad", "sad", 0),
                Arguments.of("mississippi", "issip", 4)
        );
    }
}
