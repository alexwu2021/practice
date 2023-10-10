package com.practice.Design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class LogSystemTest {

    @Test
    void put() {
    }

    @Test
    void retrieve() {
        LogSystem logSystem = new LogSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:01:22:59:59");
        logSystem.put(3, "2016:01:01:00:00:00");

        List<Integer>actual, expected;
        actual = logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year");
        expected = Arrays.asList(new Integer[]{3, 2, 1});
        assertArrayEquals(expected.toArray(), actual.toArray());


        actual = logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour");
        expected = Arrays.asList(new Integer[]{2, 1});
        assertArrayEquals(expected.toArray(), actual.toArray());

    }
}