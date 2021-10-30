package Medium;


import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> res = new LinkedList<>();
        if (mat == null || mat.length == 0) return res;

        int rowCount = mat.length, colCount = mat[0].length;
        int up = 0,  down = rowCount - 1;
        int left = 0, right = colCount - 1;
        int tot = rowCount * colCount;

        //        left -> down -> right -> up ->left

        while (res.size() < tot) {
            //            left shift
            for (int c = left; c <= right && res.size() < tot; c++)
                res.add(mat[up][c]);

            //            down shift
            for (int r = up + 1; r <= down - 1 && res.size() < tot; r++)
                res.add(mat[r][right]);

            //            right shift
            for (int c = right; c >= left && res.size() < tot; c--)
                res.add(mat[down][c]);

            //            up shift
            for (int r = down - 1; r >= up + 1 && res.size() < tot; r--)
                res.add(mat[r][left]);

            left++;
            down--;
            right--;
            up++;
        }
        return res;
    }
}