package com.company.greedy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeetingsInOneRoomTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testMeetingsInOneRoom(int[] start, int[] end, int n, int expectedResult) {
        int result = new MeetingsInOneRoom().maxMeetings(start, end, n);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 0, 5, 8, 5}, new int[]{2, 4, 6, 7, 9, 9}, 6, 4),
                Arguments.of(new int[]{10, 12, 20}, new int[]{20, 25, 30}, 3, 1),
                Arguments.of(new int[]{2, 5, 7}, new int[]{7, 8, 9}, 3, 2));
    }
}
