package Easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MaxWordsGeneratedTest {

    @Test
    public void generate() {
        MaxWordsGenerated maxWordsGenerated = new MaxWordsGenerated();
        List<String> words, actual, expected;
        List<Character>letters;

        words = Arrays.asList("dog", "og", "cat");
        letters = Arrays.asList('o', 'g', 'd');
        actual = maxWordsGenerated.generate(words, letters);
        expected = Arrays.asList("dog");
        assertNotNull(actual);
        assertTrue(actual.containsAll(expected) && expected.containsAll(actual));



        words = Arrays.asList("dog", "do", "go");
        letters = Arrays.asList('o', 'g', 'd', 'o');
        actual = maxWordsGenerated.generate(words, letters);
        expected = Arrays.asList("do", "go");
        assertNotNull(actual);
        assertTrue(actual.containsAll(expected) && expected.containsAll(actual));

    }
}