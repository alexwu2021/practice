package Medium;

import java.util.LinkedList;
import java.util.List;

public class WaterRidgeLine {

    int[][]dir = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ret = new LinkedList<>();
        if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0){
            return ret;
        }

        int m = matrix.length, n = matrix[0].length;
        boolean[][]pacific = new boolean[m][n];
        boolean[][]atlantic = new boolean[m][n];

        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(i == 0 || j == 0) dfs(matrix, pacific, Integer.MIN_VALUE, i, j);
                if(i == m-1 || j == n-1) dfs(matrix, atlantic, Integer.MIN_VALUE, i, j);
            }
        }

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (pacific[i][j] && atlantic[i][j])
                    ret.add(new int[] {i, j});
        return ret;
    }

    public void dfs(int[][]matrix, boolean[][]visited, int height, int x, int y){
        int m = matrix.length, n = matrix[0].length;
        if( x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for(int[]d : dir){
            dfs(matrix, visited, matrix[x][y], x + d[0], y + d[1]);
        }
    }
}


