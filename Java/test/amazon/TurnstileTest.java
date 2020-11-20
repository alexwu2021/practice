package amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TurnstileTest {

    @Test
    public void turnsTileFunction() {

        Turnstile turnstile = new Turnstile();

        int[] times = new int[]{};
        int[] directions = new int[]{};
        int[] ret = turnstile.turnsTileFunction(times, directions);
        int[] expected = new int[times.length];

        Assert.assertArrayEquals(ret, expected);
    }
}