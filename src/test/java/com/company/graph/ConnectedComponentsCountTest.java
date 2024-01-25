package com.company.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectedComponentsCountTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testCountConnectedComponent(ArrayList<ArrayList<Integer>> list, int expectedResult) {
        int result = new ConnectedComponentsCount().countConnectedComponents(list);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>(Arrays.asList(2,3)),
                        new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(5)),
                        new ArrayList<>(Arrays.asList(4)))), 2)
        );
    }
}
