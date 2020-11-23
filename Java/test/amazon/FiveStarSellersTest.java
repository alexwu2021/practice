package amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FiveStarSellersTest {

    @Test
    public void fiveStartReviews() {
        FiveStarSellers fiveStarSellers = new FiveStarSellers();
        int threshold = 77;
        int[][] productRatings = new int[3][];
        int i = 0;
        productRatings[i++] = new int[]{4, 4};
        productRatings[i++] = new int[]{1, 2};
        productRatings[i++] = new int[]{3, 6};

        int expected = 3;
        int actual =  fiveStarSellers.fiveStartReviews(productRatings, threshold);
        Assert.assertEquals(expected, actual);
    }
}