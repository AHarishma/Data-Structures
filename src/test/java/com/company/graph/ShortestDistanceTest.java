package com.company.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShortestDistanceTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testShortestDistance(ArrayList<ArrayList<Integer>> list, int[] expectedResult) {
        int[] result = new ShortestDistance().shortestDistance(list, 0);
        assertArrayEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1, 2)), new ArrayList<>(Arrays.asList(0, 4)),
                        new ArrayList<>(Arrays.asList(0, 3)), new ArrayList<>(Arrays.asList(2, 4)), new ArrayList<>(Arrays.asList(1, 3)))), new int[]{0, 1, 1, 2, 2})
        );
    }
}
