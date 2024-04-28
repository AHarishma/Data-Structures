package com.company.string;

import com.company.stack.LongestSubstringLength;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringLengthTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testLongestSubstringLength(String s, int k, int expectedResult) {
        int result = new LongestSubstringLength().longestSubstringLengthWithKDistinctCharacters(s, k);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("aabbcc", 1, 2),
                Arguments.of("aabbcc", 2, 4),
                Arguments.of("aabbcc", 3, 6)
        );
    }
}
