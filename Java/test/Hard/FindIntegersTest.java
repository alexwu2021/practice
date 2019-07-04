package Hard;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class FindIntegersTest {

    @Test
    public void findIntegers() {
        FindIntegers findIntegers = new FindIntegers();
        int num = 5;
        int expected = 5;
        int actual = findIntegers.findIntegers(num);
        assertTrue(actual == expected);
    }


    @Test
    public void findIntegers_pairwise() {
        FindIntegers findIntegers = new FindIntegers();
        Random random = new Random(System.currentTimeMillis());

        for(int i = 0; i < 6; ++i){
            int num = random.nextInt(100);
            int expected = findIntegers.findIntegers_plain(num);
            int actual = findIntegers.findIntegers(num);
            assertTrue(actual == expected);
        }
    }
}