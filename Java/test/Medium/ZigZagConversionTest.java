package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZigZagConversionTest {

    @Test
    public void convert() {
        ZigZagConversion sol = new ZigZagConversion();
        String s, actual, expected;
        int n;

        s = "PAYPALISHIRING";
        n = 3;
        expected =  "PAHN" +
                    "APLSIIG" +
                    "YIR";
        actual = sol.convert(s, n);
        Assert.assertEquals(expected, actual);

    }
}