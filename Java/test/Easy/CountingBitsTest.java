package Easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

import static org.junit.Assert.*;

public class CountingBitsTest {

    @Test
    public void countBits() {
        CountingBits sol = new CountingBits();
        int[] actual, expected;
        Random random = new Random(System.currentTimeMillis());
        for(int i = 0; i< 10; ++i){
            int n = random.nextInt(100) + 1;
            expected = sol.countBits(n);
            actual = sol.countBits(n);
            Assert.assertArrayEquals(expected, actual);
        }
    }
}