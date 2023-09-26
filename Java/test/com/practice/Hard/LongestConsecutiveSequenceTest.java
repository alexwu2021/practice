package com.practice.Hard;

import com.practice.Easy.Hard.LongestConsecutiveSequence;
import org.junit.Test;

public class LongestConsecutiveSequenceTest {

    @Test
    public void longestConsecutive() {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int [] input = new int [] {100, 4, 200, 1, 3, 2};
        int actual, expected;

        actual = longestConsecutiveSequence.longestConsecutive(input);
        expected = 4;
        assert(actual == expected);

    }
}