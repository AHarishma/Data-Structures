package com.company.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdgesListDfsTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testEdgesListDfs(int[][] edges, int n, List<Integer> expectedResult) {
        List<Integer> result = new EdgesListDfs().depthFirstSearch(edges, n);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        int[][] edges = new int[][]{
                {0, 2},
                {0, 3},
                {0, 1},
                {1, 0},
                {2, 0},
                {2, 4},
                {3, 0},
                {4, 2}
        };
        return Stream.of(
                Arguments.of(edges, 6, Arrays.asList(0, 2, 4, 3, 1))
        );
    }
}
