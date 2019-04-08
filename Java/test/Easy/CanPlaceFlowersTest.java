package Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class CanPlaceFlowersTest {

    @Test
    public void canPlaceFlowers() {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        int [] flowerbed = new int[]{1,0,0,0,0,1};
        int n = 2;
        boolean res = false;
//        res = canPlaceFlowers.canPlaceFlowers(flowerbed, n);
//        assert(res == false);

//        flowerbed = new int[]{0,0,1,0,1};
//        n = 1;
//        res = canPlaceFlowers.canPlaceFlowers(flowerbed, n);
//        assert(res == true);

//        flowerbed = new int[]{1, 0, 0,0,1,0,0};
//        n = 2;
//        res = canPlaceFlowers.canPlaceFlowers(flowerbed, n);
//        assert(res == true);
//

        flowerbed = new int[]{0,0,0,0,1};
        n = 3;
        res = canPlaceFlowers.canPlaceFlowers(flowerbed, n);
        assert(res == false);

    }
}