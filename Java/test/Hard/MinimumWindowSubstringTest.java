package Hard;

//import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumWindowSubstringTest {

    @Test
    public void minWindow() {

        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();

        String S, T, expected, actual;
        S = "ADOBECODEBANC";
        T = "ABC";
        expected = "BANC";
        actual = minimumWindowSubstring.minWindow(S, T);
        assertNotNull(actual);
        assert(actual.equals(expected));

    }
}