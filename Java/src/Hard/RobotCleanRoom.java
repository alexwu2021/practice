package Hard;


import java.util.HashSet;
import java.util.Set;

/**
 * Given a robot cleaner in a room modeled as a grid.
 *
 * Each cell in the grid can be empty or blocked.
 *
 * The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
 *
 * When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
 *
 * Design an algorithm to clean the entire room using only the 4 given APIs shown below.
 *
 * interface Robot {
 *   // returns true if next cell is open and robot moves into the cell.
 *   // returns false if next cell is obstacle and robot stays on the current cell.
 *   boolean move();
 *
 *   // Robot will stay on the same cell after calling turnLeft/turnRight.
 *   // Each turn will be 90 degrees.
 *   void turnLeft();
 *   void turnRight();
 *
 *   // Clean the current cell.
 *   void clean();
 * }
 * Example:
 *
 * Input:
 * room = [
 *   [1,1,1,1,1,0,1,1],
 *   [1,1,1,1,1,0,1,1],
 *   [1,0,1,1,1,1,1,1],
 *   [0,0,0,1,0,0,0,0],
 *   [1,1,1,1,1,1,1,1]
 * ],
 * row = 1,
 * col = 3
 *
 * Explanation:
 * All grids in the room are marked by either 0 or 1.
 * 0 means the cell is blocked, while 1 means the cell is accessible.
 * The robot initially starts at the position of row=1, col=3.
 * From the top left corner, its position is one row below and three columns right.
 * Notes:
 *
 * The input is only given to initialize the room and the robot's position internally. You must solve this problem "blindfolded". In other words, you must control the robot using only the mentioned 4 APIs, without knowing the room layout and the initial robot's position.
 * The robot's initial position will always be in an accessible cell.
 * The initial direction of the robot will be facing up.
 * All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
 * Assume all four edges of the grid are all surrounded by wall.
 * Accepted
 */
public class RobotCleanRoom {

    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();
        public void turnRight();

        // Clean the current cell.
        public void clean();
    }

    final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /** inspired by self_learner
     * @param robot
     */
    public void cleanRoom(Robot robot) {
        int[] pos = {0, 0};
        Set<String> visited = new HashSet<String>();
        backtracking(robot, pos, visited, 0);
    }

    /**
     * move forward - move;
     * move right - turnRight, move;
     * move backward - turnRight, turnRight, move;
     * move left - turnRight, turnRight, turnRight, move;
     *
     * @param robot
     * @param pos
     * @param visited
     * @param currDir
     */
    private void backtracking(Robot robot, int[] pos, Set<String> visited, int currDir) {
        String position = pos[0] + "," + pos[1]; // use String to keep track of visited positions
        if (visited.contains(position)) {
            return;
        }
        visited.add(position);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            if (!robot.move()) {
                robot.turnRight();
                continue;
            }

            int newDir = (currDir + i) % 4;
            int[] newPos = {pos[0] + dirs[newDir][0], pos[1] + dirs[newDir][1] };

            backtracking(robot, newPos, visited, newDir);

            robot.turnRight(); //backtracking; move the robot to its original position and facing direction
            robot.turnRight();
            robot.move();

            robot.turnLeft(); //here equals to 3 turnright(); two of them are for backtracking
        }
    }
}
