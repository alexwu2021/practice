package Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseStringTest {

    @Test
    public void reverseString() {
        ReverseString reverseString = new ReverseString();
        char[] source = new char[]{'h', 'e', 'l'};
        reverseString.reverseString(source);

        assert(source.length ==3 && source[0] == 'l');

    }
}