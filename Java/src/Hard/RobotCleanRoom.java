package Hard;


import java.util.HashSet;
import java.util.Set;

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
