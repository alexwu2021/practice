package amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumDifficultyOfJobScheduleTest {

    @Test
    public void minDifficulty() {

        MinimumDifficultyOfJobSchedule minimumDifficultyOfJobSchedule = new MinimumDifficultyOfJobSchedule();
        int[] jobDifficulty = new int[]{7,1,7,1,7,1};
        int d = 3;
        int expected = 15;
        int actual = 0;
        actual = minimumDifficultyOfJobSchedule.minDifficulty(jobDifficulty, d);
        Assert.assertEquals(expected, actual);

        jobDifficulty = new int[]{6,5,4,3,2,1};
        d = 2;
        expected = 7;
        actual = minimumDifficultyOfJobSchedule.minDifficulty(jobDifficulty, d);
        Assert.assertEquals(expected, actual);


        jobDifficulty = new int[]{9,9,9};
        d = 4;
        expected = -1;
        actual = minimumDifficultyOfJobSchedule.minDifficulty(jobDifficulty, d);
        Assert.assertEquals(expected, actual);


        jobDifficulty = new int[]{11,111,22,222,33,333,44,444};
        d = 6;
        expected = 843;
        actual = minimumDifficultyOfJobSchedule.minDifficulty(jobDifficulty, d);
        Assert.assertEquals(expected, actual);
    }
}