package com.company.greedy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivitySelectionTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testActivitySelection(int[][] arr, int expectedResult) {
        int result = new ActivitySelection().getNoOfActivities(arr);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2}, {3, 4}, {0, 6}, {8, 9}, {5, 7}, {5, 9}}, 4),
                Arguments.of(new int[][]{{1, 2}, {0, 6}}, 1));
    }
}
