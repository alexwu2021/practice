package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicateCharactersTest {

    @Test
    public void removeDuplicateLetters() {

        DuplicateCharacters sol = new DuplicateCharacters();
        String s, actual, expected;

        s = "cbacdcbc";
        actual= sol.removeDuplicateLetters(s);
        expected = "abcd";
        Assert.assertEquals(expected, actual);
    }
}