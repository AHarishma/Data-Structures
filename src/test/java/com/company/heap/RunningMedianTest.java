package com.company.heap;

import com.company.bitmanipulation.UnsetBit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RunningMedianTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testFindRunningMedian(int[] arr, int[] expectedResult) {
        int[] result = new RunningMedian().findRunningMedian(arr);
        assertArrayEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 5, 4, 3}, new int[]{1, 1, 2, 2, 3}),
                Arguments.of(new int[]{5, 17, 100, 11}, new int[]{5, 5, 17, 11}),
                Arguments.of(new int[]{-1, -2, -3, -4, -5}, new int[]{-1, -2, -2, -3, -3})
        );
    }
}
