package com.company.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static java.util.Arrays.asList;

public class RepeatedDNASequencesTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testRepeatedDNASequences(String s, List<String> expectedResult) {
        List<String> result = new RepeatedDNASequences().findRepeatedDnaSequences(s);
        assertEquals(result, expectedResult);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", new ArrayList<String>(asList("AAAAACCCCC", "CCCCCAAAAA"))),
                Arguments.of("AAAAAAAAAAAAA", new ArrayList<String>(asList("AAAAAAAAAA"))),
                Arguments.of("A", new ArrayList<String>(asList()))
        );
    }
}
