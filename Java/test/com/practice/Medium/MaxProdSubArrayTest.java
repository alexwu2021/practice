package com.practice.Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProdSubArrayTest {

    @Test
    public void maxProduct() {
        MaxProdSubArray maxProdSubArray = new MaxProdSubArray();
        int [] nums;
        int res;
//        nums = new int[]{2, 3, -2, 4};
//        res = maxProdSubArray.maxProduct(nums);
//        assert(res == 6);

        nums = new int[]{3, -1, 4};
        res = maxProdSubArray.maxProduct(nums);
        assert(res == 4);

        nums = new int[]{-3, -4};
        res = maxProdSubArray.maxProduct(nums);
        assert(res == 12);


        nums = new int[]{-2, 3, -4};
        res = maxProdSubArray.maxProduct(nums);
        assert(res == 24);
    }
}