package com.practice.Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class JewelsAndStonesTest {

    @Test
    public void numJewelsInStones() {

        JewelsAndStones jewelsAndStones = new JewelsAndStones();

        String J = "aA", S = "aAAbbbb";
        int res = jewelsAndStones.numJewelsInStones(J, S);
        assert(res == 3);


        J = "aA";
        S = "baAAbbbb";
        res = jewelsAndStones.numJewelsInStones(J, S);
        assert(res == 3);
    }
}