package com.company.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopologicalSortTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testTopologicalSort(int[][] edges, int n, List<Integer> expectedResult) {
        List<Integer> result = new TopologicalSort().topologicalSort(edges, n);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        int[][] edges = new int[][]{
                {1, 2},
                {1, 4},
                {2, 3},
                {4, 3},
                {4, 5},
                {3, 6},
                {5, 6}
        };
        return Stream.of(
                Arguments.of(edges, 6, Arrays.asList(1, 2, 4, 3, 5, 6))
        );
    }
}
