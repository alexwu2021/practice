package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfDiceRollsWithTargetSumTest {

    @Test
    public void numRollsToTarget() {

        NumberOfDiceRollsWithTargetSum sol = new NumberOfDiceRollsWithTargetSum();
        int d, f, target, actual, expected, actual2;

        d = 1;
        f = 6;
        target = 3;
        expected = 1;
        actual = sol.numRollsToTarget(d, f, target);
        actual2 = sol.numRollsToTarget2(d, f, target);
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, actual2);

        d = 2;
        f = 6;
        target = 7;
        expected =  6;
        //        You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
        //        1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
        actual = sol.numRollsToTarget(d, f, target);
        actual2 = sol.numRollsToTarget2(d, f, target);
        Assert.assertEquals(expected, actual);
        //Assert.assertEquals(expected, actual2);


//        d = 2;
//        f = 5;
//        target = 10;
//        expected =  1;
//        //        You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.
//        actual = sol.numRollsToTarget(d, f, target);
//        actual2 = sol.numRollsToTarget2(d, f, target);
//        Assert.assertEquals(expected, actual);
//        //Assert.assertEquals(expected, actual2);


        d = 1; f = 2; target = 3;
        expected = 0;
//        You throw one die with 2 faces.  There is no way to get a sum of 3.
        actual = sol.numRollsToTarget(d, f, target);
        actual2 = sol.numRollsToTarget2(d, f, target);
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, actual2);


        d = 30;
        f = 30;
        target = 500;
        expected = 222616187;
        actual = sol.numRollsToTarget(d, f, target);
        actual2 = sol.numRollsToTarget(d, f, target);
        Assert.assertEquals(expected, actual);
//        Assert.assertEquals(expected, actual2);


    }
}