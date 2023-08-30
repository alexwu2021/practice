package com.practice.Medium;

import java.util.*;

public class PathInGrid {

    // for readability
    private static final char START     = 'K';
    private static final char END       = 'C';
    private static final char WALL      = 'X';
    private static final char PASSABLE  = '*';

    // to make the neighbor exploration easier to write
    // it goes clockwise starting from the left side of the current cell
    private final int[][] navigation = new int[][] {    {-1, 0},    // left
                                                        {0, 1},     // top
                                                        {1, 0},     // right
                                                        {0, -1}     // bottom
                                                    };


    /** this function just cares if the cell of (i, j) is usable
     *  here we check the grid boundaries, and check if the cell content is a WALL or an obstacle
     * @param i
     * @param j
     * @param matrix
     * @return
     */
    private boolean isSafeToStepOn(int i, int j, char matrix[][]) {
        if(i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length //grid bourndary checking
                && matrix[i][j] != WALL){
            return true;
        }
        return false;
    }

    /** find a single path with queue
     * @param grid
     * @return
     */
    public boolean findAPathUsingQueue(char grid[][]) {

        // error checking
        if(grid == null || grid.length <= 0 || grid[0].length <= 0 ){
            System.out.println("bad input!");
            return false;
        }

        // first, locate the START cell, if its location is provided, no search is needed
        int numRows = grid.length;
        int numCols = grid[0].length;
        boolean visited[][] = new boolean[numRows][numCols];  // 1 to 1 mapping to track if it is visited
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(grid[i][j] == START && !visited[i][j]){
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }


        // second, declare data structure needed
        // the mp stores which step is the parent of the current step
        Map<int[], int[]>childToParentMap = new HashMap<>();

        // a cell is 2 dimension array of length 2
        // so path is a list of cells
        List<int[]> path = new ArrayList<>();


        // third, the algo body, process one at a time to reduce the problem size
        // loop through the queue till either a path has been found or the queue is emtpy
        boolean isAPath = false;
        while(!queue.isEmpty()){
            int[] curr = queue.remove();
            visited[curr[0]][curr[1]] = true;
            if(grid[curr[0]][curr[1]] == END){
                isAPath = true;

                // now it is the best time for us to construct the whole path
                path.add(curr);
                while(childToParentMap.containsKey(curr)){
                    int[] parent = childToParentMap.get(curr);
                    path.add(parent);
                    curr = parent; // relay
                }
                // since build the path from END to START, so we reverse the list
                // to ensure it starts from START
                Collections.reverse(path);
                break;
            }

            // relay, by exploration its 4 neighbours
            for(int k = 0; k< navigation.length; k++){
                int row = curr[0]+ navigation[k][0];
                int col = curr[1] + navigation[k][1];
                if(isSafeToStepOn(row, col, grid) && !visited[row][col]){
                    int[] child = new int[]{row, col};
                    queue.add(child);

                    // it is cheap for us just keep the relative order between two cell
                    // rather than keep the whole path info
                    childToParentMap.put(child, curr);
                }
            }
        }

        // just show the content of the path for visualization
        for(int[] step: path){
            System.out.println("(" + step[0] + "," + step[1] + ") ");
        }

        return isAPath;
    }

    /** find a single path with stack
     * @param grid
     * @return
     */
    public boolean findAPathUsingStack(char grid[][]) {

        // error checking
        if(grid == null || grid.length <= 0 || grid[0].length <= 0 ){
            System.out.println("bad input!");
            return false;
        }

        // first, locate the START cell, if its location is provided, no search is needed
        int numRows = grid.length;
        int numCols = grid[0].length;
        boolean visited[][] = new boolean[numRows][numCols];  // 1 to 1 mapping to track if it is visited
        Stack<int[]>stack = new Stack<>();
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(grid[i][j] == START && !visited[i][j]){
                    visited[i][j] = true;
                    stack.push(new int[]{i, j});
                }
            }
        }

        // second, declare data structure needed
        // the mp stores which step is the parent of the current step
        Map<int[], int[]>childToParentMap = new HashMap<>();

        // a cell is 2 dimension array of length 2
        // so path is a list of cells
        List<int[]> path = new ArrayList<>();


        // third, the algo body, process one at a time to reduce the problem size
        // loop through the stack till either a path has been found or the queue is emtpy
        boolean isAPath = false;
        while(!stack.empty()){
            int[] curr = stack.pop();
            visited[curr[0]][curr[1]] = true;
            if(grid[curr[0]][curr[1]] == END){
                isAPath = true;

                // now it is the best time for us to construct the whole path
                path.add(curr);
                while(childToParentMap.containsKey(curr)){
                    int[] parent = childToParentMap.get(curr);
                    path.add(parent);
                    curr = parent; //relay
                }

                // since build the path from END to START, so we reverse the list
                // to ensure it starts from START
                Collections.reverse(path);
                break;
            }

            // relay, by exploration its 4 neighbours
            for(int k = 0; k< navigation.length; k++){
                int row = curr[0]+ navigation[k][0];
                int col = curr[1] + navigation[k][1];
                if(isSafeToStepOn(row, col, grid) && !visited[row][col]){
                    int[] child = new int[]{row, col};
                    stack.push(child);

                    // it is cheap for us just keep the relative order between two cell
                    // rather than keep the whole path info
                    childToParentMap.put(child, curr);
                }
            }
        }

        for(int[] step: path){
            System.out.println("(" + step[0] + "," + step[1] + ") ");
        }
        return isAPath;
    }

    /** driver program
     * @param args
     */
    public static void main (String[] args) {
        boolean hasAPath;
        PathInGrid instance = new PathInGrid();

        // 4 by 4, good case
        char[][] grid = {   {WALL,      PASSABLE,   WALL,       START},
                {PASSABLE,  WALL,       PASSABLE,   PASSABLE},
                {END,       PASSABLE,   PASSABLE,   PASSABLE},
                {WALL,      PASSABLE,   PASSABLE,   PASSABLE}    };


        System.out.println("grid has " + grid.length + " rows, and " + grid[0].length + " columns.");
        hasAPath = instance.findAPathUsingQueue(grid);
        System.out.println("findAPathUsingQueue run result:" + hasAPath);

        hasAPath = instance.findAPathUsingStack(grid);
        System.out.println("findAPathUsingStack run result:" + hasAPath);


        // 4 by 5, good case
        char[][] grid2 = { {WALL,      PASSABLE,   WALL,       PASSABLE,   START},
                {PASSABLE,  WALL,       PASSABLE,   PASSABLE,   PASSABLE},
                {PASSABLE,  PASSABLE,   PASSABLE,   PASSABLE,   PASSABLE},
                {WALL,      PASSABLE,   PASSABLE,   END,        PASSABLE}};

        System.out.println("grid2 has " + grid2.length + " rows, and " + grid2[0].length + " columns.");

        hasAPath = instance.findAPathUsingQueue(grid2);
        System.out.println("findAPathUsingQueue run result on grid2:" + hasAPath);

        hasAPath = instance.findAPathUsingStack(grid2);
        System.out.println("findAPathUsingStack run result on grid2:" + hasAPath);


        // no END in the grid, bad case
        char[][] grid3 = { {WALL,      PASSABLE,   PASSABLE,   START}};

        System.out.println("grid3 has " + grid3.length + " rows, and " + grid3[0].length + " columns.");

        hasAPath = instance.findAPathUsingQueue(grid3);
        System.out.println("findAPathUsingQueue run result on grid3:" + hasAPath);

        hasAPath = instance.findAPathUsingStack(grid3);
        System.out.println("findAPathUsingStack run result on grid3:" + hasAPath);

        // has END in the grid but blocked by WALL, bad case
        char[][] grid4 = { {END,      WALL,   PASSABLE,   START}};

        System.out.println("grid4 has " + grid4.length + " rows, and " + grid4[0].length + " columns.");

        hasAPath = instance.findAPathUsingQueue(grid4);
        System.out.println("findAPathUsingQueue run result on grid4:" + hasAPath);

        hasAPath = instance.findAPathUsingStack(grid4);
        System.out.println("findAPathUsingStack run result on grid4:" + hasAPath);


    }

 }
