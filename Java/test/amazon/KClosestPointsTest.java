package amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class KClosestPointsTest {

    @Test
    public void kClosest() {
        KClosestPoints kClosestPoints = new KClosestPoints();
        int K = 1;
        int[][] points = new int[2][];
        points[0] = new int[]{1, 3};
        points[1] = new int[]{-2, 2};


        int[][] actual, expected = new int[1][];
        expected[0] = new int[]{-2, 2};

//        Input: points = [[3,3],[5,-1],[-2,4]], K = 2
//        Output: [[3,3],[-2,4]]
        actual = kClosestPoints.kClosest(points, K);
        Assert.assertArrayEquals(expected, actual);


        K = 2;
        points = new int[3][];
        points[0] = new int[]{3, 3};
        points[1] = new int[]{5, -1};
        points[2] = new int[]{-2, 4};

        expected = new int[2][];
        expected[0] = new int[]{3, 3};
        expected[1] = new int[]{-2, 4};

        actual = kClosestPoints.kClosest(points, K);
        Assert.assertArrayEquals(expected, actual);



    }
}