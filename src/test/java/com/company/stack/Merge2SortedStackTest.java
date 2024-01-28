package com.company.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Merge2SortedStackTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testMerge2SortedStack(Stack s1, Stack s2, Stack s) {
        Stack result = new Merge2SortedStack().mergeTwoSortedStack(s1, s2);
        assertTrue(Helper.areStacksEqual(s, result));
    }

    static Stream<Arguments> testDataProvider() {
        Stack<Integer> s1 = Helper.createStack(new int[]{9, 7, 1});
        Stack<Integer> s2 = Helper.createStack(new int[]{12, 11, 5, 2});

        Stack<Integer> s = Helper.createStack(new int[]{1, 2, 5, 7, 9, 11, 12});

        return Stream.of(
                Arguments.of(s1, s2, s)
        );
    }
}
