package com.practice.Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderlyQueueTest {

    @Test
    public void orderlyQueue() {
        OrderlyQueue orderlyQueue = new OrderlyQueue();
        String s;
        int k;

        s = "baaca";
        k = 3;
        String res = orderlyQueue.orderlyQueue(s, k);
        Assert.assertTrue(res.equals("aaabc"));
    }
}