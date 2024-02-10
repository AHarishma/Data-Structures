package com.company.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterestingArrayTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testInterestingArray(int[] arr, String expectedResult) {
        String result = new InterestingArray().solve(arr);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 6, 1, 8}, "Yes"),
                Arguments.of(new int[]{7, 5, 10, 13, 20, 28}, "No")

        );
    }
}
