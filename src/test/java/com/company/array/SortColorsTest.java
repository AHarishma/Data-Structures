package com.company.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortColorsTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testSortColors(int[] arr, int[] expectedResult) {
        int[] result = new SortColors().sortColors(arr);
        assertArrayEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2}),
                Arguments.of(new int[]{2, 0, 1}, new int[]{0, 1, 2})
        );
    }
}
