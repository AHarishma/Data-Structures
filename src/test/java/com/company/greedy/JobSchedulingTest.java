package com.company.greedy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobSchedulingTest {
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testJobScheduling(List<Job> jobs, int expectedResult) {
        int result = new JobScheduling().jobSchedule(jobs);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testDataProvider() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("a", 3, 100));
        jobs.add(new Job("b", 1, 19));
        jobs.add(new Job("c", 2, 27));
        jobs.add(new Job("d", 1, 25));
        jobs.add(new Job("e", 3, 30));
        return Stream.of(
                Arguments.of(jobs, 157)
        );

    }

    ;
}
