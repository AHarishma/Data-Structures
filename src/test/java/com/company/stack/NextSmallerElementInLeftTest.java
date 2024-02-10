package com.company.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NextSmallerElementInLeftTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testNextSmallerElementInLeft(int[] input, int[] expectedResult) {
        int[] result = new NextSmallerElementInLeft().nextSmallerElementInLeft(input);
        assertArrayEquals(expectedResult, result);
    }

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 6, 5, 6, 7, 8, 3, 1}, new int[]{-1, 2, 3, 3, 5, 6, 7, 2, -1}),
                Arguments.of(new int[]{2, 4}, new int[]{-1, 2})
        );
    }
}
