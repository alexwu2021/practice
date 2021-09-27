package Hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestPathWObstacleEliminationTest {

    @Test
    public void shortestPath() {
        ShortestPathWObstacleElimination sol = new ShortestPathWObstacleElimination();
        int[][]grid;
        int k, expected, actual, i;

        grid = new int[5][3];
        i = 0;
        grid[i++] = new int[]{0,0,0};
        grid[i++] = new int[]{1,1,0};
        grid[i++] = new int[]{0,0,0};
        grid[i++] = new int[]{0,1,1};
        grid[i++] = new int[]{0,0,0};
        k = 1;
        expected = 6;
        actual = sol.shortestPath(grid, k);
        Assert.assertEquals(expected, actual);


        i = 0;
        grid = new int[3][3];
        grid[i++] = new int[]{0,1,1};
        grid[i++] = new int[]{1,1,1};
        grid[i++] = new int[]{1,0,0};
        k = 1;
        expected = -1;
        actual = sol.shortestPath(grid, k);
        Assert.assertEquals(expected, actual);

        i = 0;
        grid = new int[5][3];
        grid[i++] = new int[]{0,1,1};
        grid[i++] = new int[]{0,1,1};
        grid[i++] = new int[]{0,0,0};
        grid[i++] = new int[]{0,1,0};
        grid[i++] = new int[]{0,1,0};
        k = 2;
        expected = 6;
        actual = sol.shortestPath(grid, k);
        Assert.assertEquals(expected, actual);



        i = 0;
        grid = new int[12][10];
        grid[i++] = new int[]{0,0,0,0,0,0,0,0,0,0};
        grid[i++] = new int[]{0,1,1,1,1,1,1,1,1,0};
        grid[i++] = new int[]{0,1,0,0,0,0,0,0,0,0};
        grid[i++] = new int[]{0,1,0,1,1,1,1,1,1,1};
        grid[i++] = new int[]{0,1,0,0,0,0,0,0,0,0};
        grid[i++] = new int[]{0,1,1,1,1,1,1,1,1,0};
        grid[i++] = new int[]{0,1,0,0,0,0,0,0,0,0};
        grid[i++] = new int[]{0,1,0,1,1,1,1,1,1,1};
        grid[i++] = new int[]{0,1,0,1,1,1,1,0,0,0};
        grid[i++] = new int[]{0,1,0,0,0,0,0,0,1,0};
        grid[i++] = new int[]{0,1,1,1,1,1,1,0,1,0};
        grid[i++] = new int[]{0,0,0,0,0,0,0,0,1,0};
        k = 1;
        expected = 20;
        actual = sol.shortestPath(grid, k);
        Assert.assertEquals(expected, actual);
    }
}