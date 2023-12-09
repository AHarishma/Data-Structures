package com.company.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

public class UnsetBitTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testUnsetKthBit(int n, int k, int expectedResult) {
        int result =  new UnsetBit().unsetKthBit(n, k);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(15, 3, 7),
                Arguments.of(7, 0, 6)
        );
    }
}