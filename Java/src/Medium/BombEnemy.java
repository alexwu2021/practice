package Medium;

public class BombEnemy {

    /** inspired by maimaihu
     *
     * only need to store one killed enemies value for a row and an array of each column;
     * if current grid value is W, this means previous stored value becomes invalid, you need to recalculate.
     * @param grid
     * @return
     */
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 ||  grid[0].length == 0) return 0;
        int max = 0;
        int killedInRow = 0;
        int m = grid.length, n = grid[0].length;
        int[] killedInCols = new int[n];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == 'W') continue;

                if(j == 0 || grid[i][j-1] == 'W'){
                    killedInRow = killedEnemiesRow(grid, i, j);
                }

                if(i == 0 || grid[i-1][j] == 'W'){
                    killedInCols[j] = killedEnemiesCol(grid,i,j);
                }

                if(grid[i][j] == '0'){
                    max = Math.max(max, killedInRow + killedInCols[j]);
                }
            }

        }

        return max;
    }

    //calculate killed enemies for row i from column j
    private int killedEnemiesRow(char[][] grid, int i, int j){
        int num = 0;
        while(j <= grid[0].length-1 && grid[i][j] != 'W'){
            if(grid[i][j] == 'E') num++;
            j++;
        }
        return num;
    }
    //calculate killed enemies for  column j from row i
    private int killedEnemiesCol(char[][] grid, int i, int j){
        int num = 0;
        while(i <= grid.length -1 && grid[i][j] != 'W'){
            if(grid[i][j] == 'E') num++;
            i++;
        }
        return num;
    }
}
