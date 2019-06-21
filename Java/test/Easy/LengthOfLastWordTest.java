package Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthOfLastWordTest {

    @Test
    public void lengthOfLastWord() {

        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        String s;
        int actual, expected;

        s = "Hello World";
        expected = 5;
        actual = lengthOfLastWord.lengthOfLastWord(s);
        assertTrue(actual == expected);


        s = "Hello World ";
        expected = 5;
        actual = lengthOfLastWord.lengthOfLastWord(s);
        assertTrue(actual == expected);


        s = "";
        expected = 0;
        actual = lengthOfLastWord.lengthOfLastWord(s);
        assertTrue(actual == expected);

        s = "  ";
        expected = 0;
        actual = lengthOfLastWord.lengthOfLastWord(s);
        assertTrue(actual == expected);


        s = "t  ";
        expected = 1;
        actual = lengthOfLastWord.lengthOfLastWord(s);
        assertTrue(actual == expected);

        s = " t  ";
        expected = 1;
        actual = lengthOfLastWord.lengthOfLastWord(s);
        assertTrue(actual == expected);

    }
}