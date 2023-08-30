package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameTest {

    @Test
    public void jump() {

        JumpGame jumpGame = new JumpGame();
        int nums[] = new int[]{2, 3, 1, 1, 4};
        int expected = 2;
        int actual = jumpGame.jump(nums);
        Assert.assertEquals(expected, actual);

    }
}