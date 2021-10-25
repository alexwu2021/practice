package Easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 *
 * You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 *
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
 *
 * Return the modified image after performing the flood fill.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 * Example 2:
 *
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
 * Output: [[2,2,2],[2,2,2]]
 *
 *
 * Constraints:
 *
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], newColor < 216
 * 0 <= sr < m
 * 0 <= sc < n
 */
public class FloodFill {
    private static int[][] dir =  new int[][]{{0,1},{1,0}, {0,-1},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][]v = new int[image.length][];
        for(int i=0; i<image.length; ++i) v[i] = new int[image[0].length];
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{sr, sc});
        int curr = image[sr][sc];
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i =0; i <sz; ++i){
                int[] f = q.poll();
                v[f[0]][f[1]] = 1;
                image[f[0]][f[1]] = newColor;
                for(int[] d : dir){
                    int r = f[0] + d[0], c = f[1] + d[1];
                    if(r>=image.length || r <0 || c >= image[0].length || c < 0 || image[r][c] != curr){
                        continue;
                    }
                    if(v[r][c] == 0) q.offer(new int[]{r, c});
                }
            }
        }
        return image;
    }

    /**
     * from shawngao
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill_dfs(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int r, int c, int color, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length
                || image[r][c] != color){ // this section has to trail behind
            return;
        }
        image[r][c] = newColor;
        fill(image, r + 1, c, color, newColor);
        fill(image, r - 1, c, color, newColor);
        fill(image, r, c + 1, color, newColor);
        fill(image, r, c - 1, color, newColor);
    }
}
