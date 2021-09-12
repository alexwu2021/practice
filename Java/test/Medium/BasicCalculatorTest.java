package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicCalculatorTest {

    @Test
    public void calculate() {

        BasicCalculator sol = new BasicCalculator();


        String s;
        int expected;
        int actual;


        // Input: s = "1 + 1"
        // Output: 2
        s = "1 + 1";
        expected = 2;
        actual = sol.calculate(s);
        Assert.assertEquals("case 1", expected, actual);

        // Input: s = " 2-1 + 2 "
        // Output: 3
        s = " 2-1 + 2 ";
        expected = 3;
        actual = sol.calculate(s);
        Assert.assertEquals("case 2", expected, actual);

        // Input: s = "(1+(4+5+2)-3)+(6+8)"
        // Output: 23
        s = "(1+(4+5+2)-3)+(6+8)";
        expected = 23;
        actual = sol.calculate(s);
        Assert.assertEquals("case 3", expected, actual);


        s = "21+47";
        expected = 68;
        actual = sol.calculate(s);
        Assert.assertEquals("case 4", expected, actual);


        s = "2147483647";
        expected = 2147483647;
        actual = sol.calculate(s);
        Assert.assertEquals("case 4", expected, actual);

        s = "-2+1";
        expected = -1;
        actual = sol.calculate(s);
        Assert.assertEquals("case 5", expected, actual);

        s = "2-(5-6)";
        expected = 3;
        actual = sol.calculate(s);
        Assert.assertEquals("case 6", expected, actual);
    }
}