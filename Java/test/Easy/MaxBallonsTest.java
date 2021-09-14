package Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxBallonsTest {

    @Test
    public void maxNumberOfBalloons() {

        MaxBallons sol = new MaxBallons();
        String text;
        int actual, expected;

        text = "nlaebolko";
        expected = 1;
        actual = sol.maxNumberOfBalloons(text);
        Assert.assertEquals(expected, actual);


        text = "loonbalxballpoon";
        expected = 2;
        actual = sol.maxNumberOfBalloons(text);
        Assert.assertEquals(expected, actual);

        text = "leetcode";
        expected = 0;
        actual = sol.maxNumberOfBalloons(text);
        Assert.assertEquals(expected, actual);


        text = "balon";
        expected = 0;
        actual = sol.maxNumberOfBalloons(text);
        Assert.assertEquals(expected, actual);



    }
}