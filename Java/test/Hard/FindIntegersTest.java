package Hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindIntegersTest {

    @Test
    public void findIntegers() {
        FindIntegers findIntegers = new FindIntegers();
        int num = 5;
        int expected = 5;
        int actual = findIntegers.findIntegers(num);
        assertTrue(actual == expected);

        num = 7;
        expected = 5;
        actual = findIntegers.findIntegers(num);
        assertTrue(actual == expected);


        num = 10;
        expected = 8;
        actual = findIntegers.findIntegers(num);
        assertTrue(actual == expected);
    }
}