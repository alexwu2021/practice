package com.practice.Medium;

public class LargestPlusSign {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int ret = 0;
        int[][]matrix = new int[n][n];
        for(int r=0; r<n; ++r){
            for(int c=0; c<n; ++c) {
                matrix[r][c] = 1;
            }
        }
        for(int[] pos: mines){
            matrix[pos[0]][pos[1]] = 0;
        }

        int[][]left = new int[n][n];
        for(int r=0; r<n; ++r){
            for(int c=0; c<n; ++c){
                if(left[r][c] == 0){
                    int count = 0;
                    for(int j = c-1; j>=0; --j){
                        if(matrix[r][j] == 0){
                            left[r][c] = count;
                            break;
                        }
                        count++;
                    }
                }
            }
        }


        return ret;
    }
}
