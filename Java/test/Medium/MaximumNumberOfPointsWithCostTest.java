package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumNumberOfPointsWithCostTest {

    @Test
    public void maxPoints() {
        MaximumNumberOfPointsWithCost sol = new MaximumNumberOfPointsWithCost();
        int[][]grid;
        long actual, expected;





//        Input: points = [[1,2,3],[1,5,1],[3,1,1]]
//        Output: 9
//        Explanation:
//        The blue cells denote the optimal cells to pick, which have coordinates (0, 2), (1, 1), and (2, 0).
//                You add 3 + 5 + 3 = 11 to your score.
//                However, you must subtract abs(2 - 1) + abs(1 - 0) = 2 from your score.
//                Your final score is 11 - 2 = 9.
        grid = new int[][]{{1,2,3},{1,5,1},{3,1,1}};
        expected = 9;
        actual = sol.maxPoints(grid);
        Assert.assertEquals(expected, actual);


//        Input: points = [[1,5],[2,3],[4,2]]
//        Output: 11
//        Explanation:
//        The blue cells denote the optimal cells to pick, which have coordinates (0, 1), (1, 1), and (2, 0).
//                You add 5 + 3 + 4 = 12 to your score.
//                However, you must subtract abs(1 - 1) + abs(1 - 0) = 1 from your score.
//                Your final score is 12 - 1 = 11.
        grid = new int[][]{{1,5},{2,3},{4,2}};
        expected = 11;
        actual = sol.maxPoints(grid);
        Assert.assertEquals(expected, actual);
    }
}