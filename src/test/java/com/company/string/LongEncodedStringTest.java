package com.company.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongEncodedStringTest {

    @ParameterizedTest
    @MethodSource("testProvider")
    public void testLongEncodedString(String s, List<Integer> expectedResult) {
        List<Integer> result = new LongEncodedString().frequency(s);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testProvider() {
        return Stream.of(Arguments.of("123", List.of(1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
                Arguments.of("1(20)10#226#(3)", List.of(20, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3)));
    }
}
