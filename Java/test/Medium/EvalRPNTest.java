package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EvalRPNTest {

    @Test
    public void evalRPN() {

//        Input: tokens = ["2","1","+","3","*"]
//        Output: 9
//        Explanation: ((2 + 1) * 3) = 9
        EvalRPN sol = new EvalRPN();
        String[] tokens;
        int actual, expected;

        tokens = new String[]{"2","1","+","3","*"};
        expected = 9;
        actual = sol.evalRPN(tokens);
        Assert.assertEquals(expected, actual);

        tokens = new String[]{"4","13","5","/","+"};
        expected = 6;
        actual = sol.evalRPN(tokens);
        Assert.assertEquals(expected, actual);


        tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        expected = 22;
        actual = sol.evalRPN(tokens);
        Assert.assertEquals(expected, actual);

    }
}