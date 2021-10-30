package Hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumWorkingTimeTest {

    @Test
    public void minimumTimeRequired() {
        MinimumWorkingTime sol = new MinimumWorkingTime();
        int []jobs;
        int k, actual, expected;

//    //        * Input: jobs = [3,2,3], k = 3
//    //                * Output: 3
//    //                * Explanation: By assigning each person one job, the maximum time is 3.
        jobs = new int[]{3, 2, 3};
        k = 3;
        expected = 3;
        actual = sol.minimumTimeRequired(jobs, k);
        Assert.assertEquals(expected, actual);



        // * Input: jobs = [1,2,4,7,8], k = 2
        //                * Output: 11
        jobs = new int []{1, 2, 4, 7, 8};
        k = 2;
        expected = 11;
        actual = sol.minimumTimeRequired(jobs, k);
        Assert.assertEquals(expected, actual);

    }
}