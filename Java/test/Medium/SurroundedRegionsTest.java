package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SurroundedRegionsTest {

    @Test
    public void solve() {
        SurroundedRegions sol = new SurroundedRegions();
        char[][] board, expected, expected_ref;

//        board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//        expected = new char[][]{{'X','X','X','X'},{'X','X','X','X'},{'X','X','X','X'},{'X','O','X','X'}};
//        sol.solve(board);
//        Assert.assertArrayEquals(board, expected);
//
//        board = new char[][]{{'X'}};
//        expected = new char[][]{{'X'}};
//        sol.solve(board);
//        Assert.assertArrayEquals(board, expected);


//        board = new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
//        expected = new char[][]{{'O','X','X','O','X'},{'X','X','X','X','O'},{'X','X','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
//        sol.solve(board);
//        Assert.assertArrayEquals(board, expected);


        board = new char[][]{{'O','X','X','O','O', 'O'},{'X','O','O','O','X','O'},{'O','X','O','X','O','X'},{'O', 'X','X','O','X','O'},{'X', 'O','X','O','X','O'}};
        sol.solve_mine(board);
        expected = board;

        sol.solve(board);
        expected_ref = board;
        Assert.assertArrayEquals(expected_ref, expected);

    }
}