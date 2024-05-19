package com.company.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SearchForRangeTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testSearchForRange(int[] arr, int target, int[] expectedResult) {
        int[] result = new SearchForRange().searchForRange(arr, target);
        assertArrayEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 3, 6, 8, 8, 8, 10, 10, 40, 40, 50}, 8, new int[]{5, 7}),
                Arguments.of(new int[]{1, 2, 3, 3, 6, 8, 8, 8, 10, 10, 40, 40, 50}, 9, new int[]{-1, -1})
        );
    }
}
