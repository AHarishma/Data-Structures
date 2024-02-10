package com.company.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortStackTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testSortStack(Stack s, Stack expectedResult) {
        Stack result = new SortStack().sortStack(s);
        assertTrue(Helper.areStacksEqual(expectedResult, result));
    }

    static Stream<Arguments> testDataProvider() {
        Stack<Integer> s1 = Helper.createStack(new int[]{1, 9, 7});
        Stack<Integer> s2 = Helper.createStack(new int[]{5, 11, 12, 7});
        Stack<Integer> result1 = Helper.createStack(new int[]{9, 7, 1});
        Stack<Integer> result2 = Helper.createStack(new int[]{12, 11, 7, 5});
        Stack<Integer> s3 = Helper.createStack(new int[]{3, 2, 1});

        return Stream.of(
                Arguments.of(s1, result1),
                Arguments.of(s2, result2),
                // TODO
                Arguments.of(s3, s3)
        );
    }
}
