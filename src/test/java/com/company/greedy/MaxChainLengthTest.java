package com.company.greedy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxChainLengthTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testMaxChainLength(MaxChainLength.Pair[] arr, int n, int expectedResult) {
        int result = new MaxChainLength().maxChainLength(arr, n);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        MaxChainLength.Pair[] arr1 = {new MaxChainLength.Pair(5, 10), new MaxChainLength.Pair(1, 11)};
        MaxChainLength.Pair[] arr2 = {
                new MaxChainLength.Pair(5, 24), new MaxChainLength.Pair(39, 60),
                new MaxChainLength.Pair(15, 28), new MaxChainLength.Pair(27, 40),
                new MaxChainLength.Pair(50, 90)};
        return Stream.of(
                Arguments.of(arr1, 2, 1),
                Arguments.of(arr2, 5, 3));

    }
}
