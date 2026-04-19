package com.company.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrieTest {

    private Trie trie;

    @BeforeEach
    void setUp() {
        trie = new Trie();
        trie.insert("flower");
        trie.insert("flow");
        trie.insert("flight");
    }

    @ParameterizedTest
    @MethodSource("testSearchFullWordDataProvider")
    public void testSearchFullWord(String word, boolean expectedResult) {
        boolean result = trie.search(word);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testSearchFullWordDataProvider() {
        return Stream.of(
                Arguments.of("flower", true),
                Arguments.of("flight", true),
                Arguments.of("fly", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testStartsWithDataProvider")
    public void testStartsWith(String prefix, boolean expectedResult) {
        boolean result = trie.prefix(prefix);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testStartsWithDataProvider() {
        return Stream.of(
                Arguments.of("fl", true)
        );
    }
}
