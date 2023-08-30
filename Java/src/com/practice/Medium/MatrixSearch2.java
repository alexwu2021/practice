package com.practice.Medium;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has
 * the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 */
class MatrixSearch2 {

    /**
     * Copied here from dinhnguyen92 for learning
     * This is probably the best we can get
     *
     *
     * The main idea behind this approach:

     _ Keep eliminating rows in the matrix until only 1 row is left

     _ Carry out binary search in the single row that is left

     To eliminate rows, or block of rows, three important characteristics of the matrix are used:

     _ If the target is smaller than the element in the top left corner, the target must be smaller than all elements in the block and therefore is not in the block.

     _If the target is larger than the element in the bottom right corner, the target must be larger than all elements in the block and therefore is not in the block.

     _If the target is between the top left and bottom right elements, then the target may or may not be in the block. If the target is in the block, the target can be anywhere in the block.
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix.length == 0 || matrix == null) return false;
        return recursiveSearch(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }

    private boolean recursiveSearch(int[][] matrix, int row1, int col1, int row2, int col2, int target)
    {
        // If matrix dimensions are invalid
        if (row2 < row1 || col2 < col1) return false;
        // If matrix is a single row, do binary search
        if (row1 == row2) return binarySearch(matrix, row1, col1, col2, target);
            // If target is not with range of matrix
        else if (target < matrix[row1][col1] || target > matrix[row2][col2]) return false;

        int midRow = (row2 - row1)/2 + row1;

        // If target is found in upper sub-matrix
        if (recursiveSearch(matrix, row1, col1, midRow, col2, target)) return true;
        // If target is found in lower sub-matrix
        if (recursiveSearch(matrix, midRow + 1, col1, row2, col2, target)) return true;

        return false;
    }

    private boolean binarySearch(int[][] matrix, int row, int col1, int col2, int target)
    {
        if (col1 == col2) return (target == matrix[row][col1]);

        int midCol = (col2 - col1)/2 + col1;

        if (target <= matrix[row][midCol]) return binarySearch(matrix, row, col1, midCol, target);
        return binarySearch(matrix, row, midCol + 1, col2, target);
    }

//    boolean searchMatrix(int [][] grid, int target){
//        if(grid == null || grid.length <= 0 || grid[0].length <= 0)
//            return false;
//
//        int rowNum = grid.length;
//        int colNum = grid[0].length;
//        int begin = 0, end = rowNum * colNum - 1;
//        while ( begin <= end ) {
//            int mid = ( begin + end ) >> 1 ;
//            int row = mid / colNum;
//            int col = mid % colNum;
//
//            if( grid[row][col] == target ){
//                return true;
//            }
//
//            if(col == colNum -1 &&  grid[row + 1][0] == target){
//                return true;
//            }
//
//            if( grid[row][col] < target ) {
//                begin = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//        return false;
//    }

}
