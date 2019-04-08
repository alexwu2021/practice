package Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class IncreasingSquareSequenceTest {

    @Test
    public void findIncreasingSquares() {

        IncreasingSquareSequence increasingSquareSequence = new IncreasingSquareSequence();
        int[] res = increasingSquareSequence.findIncreasingSquares(new int[]{-7, 2, 0, 3, 5});
        assert(res[0] == 0 && res[1] == 4 &&  res[2] == 9&&  res[4] == 49 && res[3] == 25);

    }
}