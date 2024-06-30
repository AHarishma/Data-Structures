package com.company.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrumpyBookstoreOwnerTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testGrumpyBookstoreOwner(int[] customers, int[] grumpy, int minutes, int expectedResult) {
        int result = new GrumpyBookstoreOwner().maxSatisfied(customers, grumpy, minutes);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3, 16),
                Arguments.of(new int[]{1}, new int[]{0}, 1, 1)
        );
    }
}
