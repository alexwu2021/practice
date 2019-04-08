package Unclassified;

import org.junit.Test;

import java.util.Random;

public class BrokenCalculatorTest {

    @Test
    public void brokenCalc() {

        BrokenCalculator brokenCalculator = new BrokenCalculator();

        Random random = new Random(System.currentTimeMillis());

        //for(int i= 0; i< 5; ++i){
        int X = random.nextInt(20), Y = random.nextInt(30);
        X = 13;
        Y = 29;

//        X = 5;
//        Y = 8;
        int res = brokenCalculator.brokenCalc(X, Y);
        int res2 = brokenCalculator.brokenCalc2(X, Y);


        System.out.printf("X=%d, Y=%d, res=%d, res2=%d%n", X, Y, res, res2);

                //"X=%d, Y=%d, res=%d; res2=%d", X, Y, res, res2);

        assert (res2 == 4);

        //}
        return;

    }
}