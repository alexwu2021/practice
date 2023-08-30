package com.practice.Medium;

import java.util.List;

public class Triangle {


    /** passed oj
     *
     * This is something I should have mastered
     *
     * for each layer bottom up do
     *      for each element in the result array from left to right
     *            calc f[j]
     *
     *            The transition function is that f[j] = min(f[j], f[j+]) + triangle[i][j]
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i = triangle.size() - 1; i >= 0; --i){
            for(int j = 0; j <= i; ++j){ //the equal is a must
                A[j] = Math.min(A[j], A[j+1])
                        + triangle.get(i).get(j);
            }
        }
        return A[0];
    }

}
