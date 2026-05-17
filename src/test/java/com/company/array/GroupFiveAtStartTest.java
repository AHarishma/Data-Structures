package com.company.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GroupFiveAtStartTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testGroupFiveAtStart(int[] arr, int[] expectedResult) {
        int[] result = new GroupFiveAtStart().groupfiveAtStart(arr);
        assertArrayEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{5, 5, 1, 2, 3, -5, 6, 7, 8, 7, 5, 0}, new int[]{5, 5, -5, 5, 1, 2, 3, 6, 7, 8, 7, 0}),
                Arguments.of(new int[]{1, 5, 2, 5, 3, 4, 5, -5}, new int[]{5, 5, 5, -5, 1, 2, 3, 4})
        );
    }
}
