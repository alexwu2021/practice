package com.practice.Medium;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
 */
public class KthSmallestElement_SortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int cols = matrix[0].length;
        int rows  = matrix.length;
        if (k > cols * rows) return Integer.MIN_VALUE;
        Queue<Integer>pq = new PriorityQueue<>((a, b) -> (b-a));
        for (int r=0; r < rows; ++r) {
            for (int c=0; c < cols; ++c) {
                if(pq.size() < k) {
                    pq.offer(matrix[r][c]); // add is the same for pq
                }else{
                    if(matrix[r][c] < pq.peek()){
                        pq.poll();
                        pq.add(matrix[r][c]);
                    }
                }
            }
        }
        return pq.peek();
    }
}
