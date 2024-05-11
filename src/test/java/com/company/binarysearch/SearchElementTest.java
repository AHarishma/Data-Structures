package com.company.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchElementTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testSearchElement(int[] arr, int target, int expectedResult) {
        int result = new SearchElement().search(arr, target);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 4, 3),
                Arguments.of(new int[]{4, 9, 10, 11}, 33, -1),
                Arguments.of(new int[]{-30, -20, -10, 2, 3}, -20, 1)
        );
    }
}
