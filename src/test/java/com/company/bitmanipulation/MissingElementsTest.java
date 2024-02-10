package com.company.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MissingElementsTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testSingleNumber(int[] arr, int n, int[] expectedResult) {
        int[] result = new MissingElements().findMissingElement(arr, n);
        assertArrayEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 5, 6, 2}, 4, new int[]{1, 4}),
                Arguments.of(new int[]{1, 4, 5, 7, 2}, 5, new int[]{3, 6})

        );
    }
}
