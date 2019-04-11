package Easy;

public class FlipAndInvertImage {
    /** passed oj
     *
     * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
     *
     * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        if(A == null || A.length <= 0 || A[0].length <= 0) return null;
        int m = A.length, n = A[0].length, mid = n >> 1;
        for (int i = 0; i < m; ++i){
            for(int j = 0; j < mid; ++j){
                int temp = A[i][n -1 - j];
                A[i][n -1 -j] = A[i][j];
                A[i][j] = temp;
            }
        }

        for (int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j) A[i][j] = A[i][j] == 0 ? 1 : 0;
        }
        return A;
    }
}
