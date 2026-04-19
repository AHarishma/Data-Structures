package com.company.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeNumberTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testNoOfSubArrayEqualToK(int num, boolean expectedResult) {
        boolean result = new PalindromeNumber().isPalindrome(num);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(10, false),
                Arguments.of(-10, false)
        );
    }
}
