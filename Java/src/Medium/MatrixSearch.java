package Medium;

class MatrixSearch {
    boolean searchMatrix(int [][] grid, int target){
        if(grid == null || grid.length <= 0 || grid[0].length <= 0) return false;

        int m = grid.length, n = grid[0].length;
        int row = 0, col = n - 1;
        while ( row < m && col >= 0 ) {
            if( grid[row][col] == target) return true;

            if( grid[row][col] < target ) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
