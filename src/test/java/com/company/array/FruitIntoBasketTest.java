package com.company.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FruitIntoBasketTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testFruitIntoBasket(int[] fruits, int expectedResult) {
        int result = new FruitIntoBasket().totalFruit(fruits);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1}, 3),
                Arguments.of(new int[]{0, 1, 2, 2}, 3),
                Arguments.of(new int[]{1, 2, 3, 2, 2}, 4)
        );
    }
}
