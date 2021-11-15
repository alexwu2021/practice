package Medium;

import java.util.ArrayList;
import java.util.List;

public class LandGroups {
    public int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        for(int r = 0; r<land.length; ++r){
            for(int c = 0; c<land[0].length; ++c){
                if(land[r][c] == 1){
                    int[] bottomRight =new int[]{0, 0};
                    dfs(land, r, c, bottomRight);
                    list.add(new int[]{r, c, bottomRight[0], bottomRight[1]});
                }
            }
        }
        return list.toArray(new int[0][]);
    }
    public void dfs(int[][] land, int r, int c, int[] bottomRight){
        if(r<0 || c<0 || r>=land.length || c>=land[0].length || land[r][c] == 0) return;
        land[r][c] = 0;
        dfs(land, r+1, c, bottomRight);
        bottomRight[0] = Math.max(bottomRight[0], r);
        dfs(land, r, c+1, bottomRight);
        bottomRight[1] = Math.max(bottomRight[1], c);
    }
}
