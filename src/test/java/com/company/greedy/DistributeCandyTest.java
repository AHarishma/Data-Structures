package com.company.greedy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistributeCandyTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testDistributeCandy(int[] arr, int expectedResult) {
        int result = new DistributeCandy().distributeCandy(arr);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 2, 4, 5, 3, 2, 1, 4, 6}, 21),
                Arguments.of(new int[]{1, 0, 2}, 5),
                Arguments.of(new int[]{1, 2, 2}, 4));
    }
}
