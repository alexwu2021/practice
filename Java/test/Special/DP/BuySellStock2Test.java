package Special.DP;

import org.junit.Test;

public class BuySellStock2Test {

    @Test
    public void maxProfit2() {
        BuySellStock2 buySellStock2 = new BuySellStock2();
        int [] prices;
        int res, expected;

        prices = new int [] {3, 3};
        res = buySellStock2.maxProfit2(prices);
        expected = 0;
        assert(res == expected);


        prices = new int [] {7,1,5,3,6,4};
        expected = 7;
        res = buySellStock2.maxProfit2(prices);
        assert(res == expected);


        prices = new int [] {1, 2, 3, 4, 5};
        expected = 4;
        res = buySellStock2.maxProfit2(prices);
        assert(res == expected);
    }
}