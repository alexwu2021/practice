package Unclassified;

//package gridsearch

/**
 * Grid Search
 *
 * You've been given a grid of dimensions M x N. This grid is special though. There are some rules for numbers
 * in this grid.
 *
 * <ul>
 *   <li><code>grid[i][j] > grid[i][j-1]</code> for <code>0 < j < N </code></li>
 *   <li><code>grid[i][j] > grid[i-1][j]</code> for <code>0 < i < M </code></li>
 * </ul>
 *
 * <p>You must find if a given number exists in this grid at all.</p>
 * <p>Oh, and this grid can be really huge, so optimize your execution speed.</p>
 * @author rahulsomasunderam
 * @since 1/27/13 9:58 AM
 */
class GridSearch {
    static class Position {
        public int i;
        public int j;

        protected Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    /** This is the one I submitted. Complexity: lg(M*N)
     *
     * Finds the element in the grid
     *  Grid has this properties:
     *      grid[i][j] > grid[i][j-1] for 0 < j < N
     *      grid[i][j] > grid[i-1][j] for < i < M
     * @param grid
     * @param target the num to search for
     * @return a Position object
     */
    Position findInGrid(int [][] grid, int target){
        Position ret = new Position(-1, -1);
        if(grid == null || grid.length <= 0 || grid[0].length <= 0)
            return ret;

        int rowNum = grid.length;
        int colNum = grid[0].length;
        int begin = 0, end = rowNum * colNum - 1;
        while ( begin <= end ) {
            int mid = ( begin + end ) >> 1;
            int row = mid / colNum;
            int col = mid % colNum;

            if( grid[row][col] == target)
                return new Position(row, col);

            if( grid[row][col] < target ) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ret;
    }


    /** This is the plain one, easy to understand, which I didn't submit. . Complexity: M*N
     * @param grid
     * @param target
     * @return
     */
    Position findInGrid_TwoPointers(int [][] grid, int target){
        Position ret = new Position(-1, -1);
        if(grid == null || grid.length <= 0 || grid[0].length <= 0)
            return ret;

        int rowNum = grid.length;
        int colNum = grid[0].length;
        int row = 0, col = colNum - 1;
        while ( row < rowNum && col >= 0 ) {
            if( grid[row][col] == target)
                return new Position(row, col);

            if( grid[row][col] < target ) {
                row++;
            } else {
                col--;
            }
        }
        return ret;
    }
}
