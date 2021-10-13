package Medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NumberDecoderTest {

    @Test
    public void decodeNumbers() {
        NumberDecoder sol = new NumberDecoder();

        String src;
        List<String> actual;
        List<String>expected = new ArrayList<>();
//
//        src = "12";
//        actual = sol.decodeNumbers(src);
//        expected.clear();
//        expected.add("ab");
//        expected.add("l");


        src = "123";
        actual = sol.decodeNumbers(src);
        expected.clear();
        expected.add("abc");
        expected.add("lc");
        expected.add("cl");

        Assert.assertEquals(expected, actual);
    }
}