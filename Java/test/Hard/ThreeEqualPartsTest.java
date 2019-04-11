package Hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeEqualPartsTest {



    @Test
    public void threeEqualParts() {
    }

    @Test
    public void getBitValue() {
        int [] Input = new int []{1,0,1,0,1};
        int res;
        ThreeEqualParts threeEqualParts = new ThreeEqualParts();
        res = threeEqualParts.getBitValue(Input, 0, 0);
        assert(res == 1);
        res = threeEqualParts.getBitValue(Input, 1, 3);
        assert(res == 1);
        res = threeEqualParts.getBitValue(Input, 4, 4);
        assert(res == 1);
    }
}