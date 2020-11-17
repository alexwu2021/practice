package Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthOfLastWordTest {

    @Test
    public void testLengthOfLastWord() {
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

        s = "Hello My-World";
        expected = 8;
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

        s = " -123 456789";
        expected = 6;
        actual = lengthOfLastWord.lengthOfLastWord(s);
        assertTrue(actual == expected);
    }
}