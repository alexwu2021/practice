package com.practice.Medium;

/**
 * You are given two arrays rowSum and colSum of non-negative integers where rowSum[i] is the sum of the elements in the ith row and colSum[j] is the sum of the elements of the jth column of a 2D matrix. In other words, you do not know the elements of the matrix, but you do know the sums of each row and column.
 *
 * Find any matrix of non-negative integers of size rowSum.length x colSum.length that satisfies the rowSum and colSum requirements.
 *
 * Return a 2D array representing any matrix that fulfills the requirements. It's guaranteed that at least one matrix that fulfills the requirements exists.
 */
public class RestorationOfMatrix {

    /**
     * @param rowSum
     * @param colSum
     * @return
     */
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][]A = new int[m][n];
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                int temp = Math.min(rowSum[i], colSum[j]);
                A[i][j] = temp;
                rowSum[i] -= temp;
                colSum[j] -= temp;
            }
        }
        return A;
    }
}
