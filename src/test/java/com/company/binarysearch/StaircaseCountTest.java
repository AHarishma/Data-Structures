package com.company.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaircaseCountTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testStaircaseCount(int noOfBlocks, int expectedResult) {
        int result = new StaircaseCount().getStaircaseStepsCount(noOfBlocks);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(10, 4),
                Arguments.of(15, 5),
                Arguments.of(2, 1)
        );
    }
}
