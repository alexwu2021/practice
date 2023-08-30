package com.practice.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathFinder {

    int[][] nav = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}} ;

    List<List<int[]>> allPaths = new ArrayList<>();


    List<int[]> findPath(char[][] grid){
        List<int[]> ret = new ArrayList<>();
        if(grid == null){
            return ret;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        int startRow = -1, startCol = -1, endRow = -1, endCol = -1;

        for(int i=0; i<numRows; ++i){
            for(int j=0; j<numCols; ++j){
                if(grid[i][j] == 'K'){
                    startRow = i;
                    startCol = j;
                    grid[startRow][startCol] = 'V';
                    break;
                }
            }
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startRow, startCol});
        while(!stack.empty()){
            int[] curr = stack.pop();
            if(grid[curr[0]][curr[1]] == 'C'){
                endRow = curr[0];
                endCol = curr[1];
                break;
            }

            grid[curr[0]][curr[1]] = 'V'; //mark it as visited

            for(int k=0; k<=3; ++k){
                if(isSafeForExploring(curr[0] + nav[k][0], curr[1] + nav[k][1], grid, numRows, numCols)){
                    stack.push(new int[]{curr[0] + nav[k][0], curr[1] + nav[k][1]});
                }
            }
        }

        if(startRow == -1 || startCol == -1 || endRow == -1 || endCol == -1){
            return ret;
        }

        backTrack(endRow, endCol, grid, startRow, startCol, ret, numRows, numCols);

        List<int[]> shortestPath = allPaths.get(0);
        if(allPaths.size() > 1){
            for(int r=1; r<allPaths.size(); r++){
                if(allPaths.get(r).size() < shortestPath.size()){
                    shortestPath.clear();
                    shortestPath.addAll(allPaths.get(r));
                }
            }
        }
        return shortestPath;

    }


    void backTrack(int endRow, int endCol,char[][]grid, int startRow, int startCol, List<int[]>path, int numRows, int numCols){
        if(endRow == startRow && endCol == startCol){
            path.add(new int[]{startRow, startCol});
            allPaths.add(path);//in reverse order
            return;
        }

        path.add(new int[]{endRow, endCol});
        grid[endRow][endCol] = 'X';

        for(int k=0; k<=3; ++k){
            if(isSafeForBacktracking(endRow+ nav[k][0], endCol + nav[k][1], grid, numRows, numCols)){
                backTrack(endRow+ nav[k][0], endCol + nav[k][1], grid, startRow, startCol, new ArrayList<>(path), numRows, numCols);
            }
        }

        grid[endRow][endCol] = 'V';

    }


    boolean isSafeForExploring(int row, int col, char[][] grid, int numRow, int numCol){
        if(row <0 || row>numRow-1 || col < 0 || col > numCol-1)
            return false;
        if(grid[row][col] == 'X' || grid[row][col] == 'V' )
            return false;
        return true;
    }

    boolean isSafeForBacktracking(int row, int col, char[][] grid, int numRow, int numCol){
        if(row <0 || row>numRow-1 || col < 0 || col > numCol-1)
            return false;
        if(grid[row][col] != 'V' )
            return false;
        return true;
    }
}
