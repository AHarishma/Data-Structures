package com.company.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonPrefixTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testLongestCommonPrefix(String[] strs, String expectedResult) {
        String result = new LongestCommonPrefix().longestCommonPrefix(strs);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new String[]{"flight", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"dog", "racecar", "car"}, "")
        );
    }
}
