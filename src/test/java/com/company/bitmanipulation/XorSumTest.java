package com.company.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XorSumTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testXorSum(int[] arr, int expectedResult) {
        int result = new XorSum().xorSumAllPairs(arr);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 5, 6, 8, 2}, 148)
        );
    }
}

/**
 * TC - O(Nlog(max(arr))) or O(N)
 * SC - O(1)
 */
