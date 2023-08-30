package com.practice.Medium;

/*
failed at this test case and will revisit later

and error message is
java.lang.ArrayIndexOutOfBoundsException: 2
  at line 57, Vector2D.next
  at line 57, __Driver__.__helperSelectMethod__
  at line 78, __Driver__.__helper__

test case is

["Vector2D","next","next","next","hasNext","hasNext","next","hasNext"]
[[[[1,2],[3],[4]]],[null],[null],[null],[null],[null],[null],[null]]
*/

public  class Vector2D {
    int row, col;
    int[][] vec;

    /**
     * @param v
     *
     * In fact, this version runs faster than the followup one
     * which employes iterator
     * Runtime: 54 ms
     * Memory Usage: 47.5 MB
     */
    public Vector2D(int[][] v) {
        this.vec = v;
        row = col = 0;
    }

    public int next() {
        if (!hasNext())
            return Integer.MIN_VALUE;

        int ret =  vec[row][col];
        col++;
        return ret;
    }

    public boolean hasNext() {
        if (row >= vec.length) return false;
        if (col >= vec[row].length) {
            col = 0;
            row++;
            return hasNext();
        }
        return true;
    }
}
