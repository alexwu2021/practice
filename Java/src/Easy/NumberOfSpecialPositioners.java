package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Special Positions in a Binary Matrix
 * Given a rows x cols matrix mat, where mat[i][j] is either 0 or 1, return the number of special positions in mat.
 *
 * A position (i,j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
 *
 *
 *
 * Example 1:
 *
 * Input: mat = [[1,0,0],
 *               [0,0,1],
 *               [1,0,0]]
 * Output: 1
 * Explanation: (1,2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
 * Example 2:
 *
 * Input: mat = [[1,0,0],
 *               [0,1,0],
 *               [0,0,1]]
 * Output: 3
 * Explanation: (0,0), (1,1) and (2,2) are special positions.
 * Example 3:
 *
 * Input: mat = [[0,0,0,1],
 *               [1,0,0,0],
 *               [0,1,1,0],
 *               [0,0,0,0]]
 * Output: 2
 * Example 4:
 *
 * Input: mat = [[0,0,0,0,0],
 *               [1,0,0,0,0],
 *               [0,1,0,0,0],
 *               [0,0,1,0,0],
 *               [0,0,0,1,1]]
 * Output: 3
 */
public class NumberOfSpecialPositioners {

    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Map<Integer, Integer>mpRows = new HashMap<>();
        Map<Integer, Integer> mpCols = new HashMap<>();

        for(int r=0; r < rows; ++r){
            int temp = 0;
            for(int c = 0; c < cols; ++c){
                temp += mat[r][c];
            }
            mpRows.put(r, temp);
        }

        for(int c=0; c < cols; ++c){
            int temp = 0;
            for(int r = 0; r < rows; ++r){
                temp += mat[r][c];
            }
            mpCols.put(c, temp);
        }

        int count = 0;
        for(int r = 0; r < rows; ++r){
            for(int c = 0; c < cols; ++c){
                if(mat[r][c] != 1){
                    continue;
                }

                if(mpRows.get(r) == 1 && mpCols.get(c) == 1)
                    count++;
            }
        }
        return count;
    }


    public int numSpecial_from_hobiter(int[][] mat) {
        int m = mat.length, n = mat[0].length, res = 0, col[] = new int[n], row[] = new int[m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 1){
                    col[j]++;
                    row[i]++;
                }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) res++;
        return res;
    }
}
