package Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>lst = new ArrayList<>();
        if(matrix == null || matrix.length <= 0 || matrix[0] == null || matrix[0].length <= 0) return lst;
        helper(matrix, new int[]{0, 0}, new int[]{matrix.length -1, matrix[0].length -1}, lst);
        return lst;
    }

    private void helper(int[][] matrix, int[] topLeft, int[] bottomRight, List<Integer>lst) {
        final int r0 = topLeft[0], c0 = topLeft[1];
        final int r1 = bottomRight[0], c1 = bottomRight[1];

        if(r1 < r0 || c1 < c0) return;
        if(r1 == r0) {
            for(int k = c0; k<= c1; ++k)
                lst.add(matrix[r1][k]);
            return;
        }

        if(c1 == c0) {
            for(int k = r0; k <= r1; ++k) lst.add(matrix[k][c1]);
            return;
        }

        int i = r0, j = c0;
        for(; j <= c1; ++j)
            lst.add(matrix[i][j]);

        i = c0 + 1;
        j = c1;
        for(; i <= r1; ++i)
            lst.add(matrix[i][j]);


        i = r1;
        j = c1 - 1;
        for(; j >= c0; --j)
            lst.add(matrix[i][j]);

        i = r1 -1;
        j = c0;
        for(; i > r0; --i)
            lst.add(matrix[i][j]);

        helper(matrix, new int[]{r0 + 1, c0 + 1}, new int[]{r1 -1, c1 -1}, lst);
    }
}