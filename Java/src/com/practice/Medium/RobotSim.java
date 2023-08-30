package com.practice.Medium;

import java.util.HashSet;
import java.util.Set;

public class RobotSim {

    static final int[][] DIR = {{0,1},{1,0},{0,-1},{-1,0}};

    /** idea from Lattes, passed oj
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        if(commands == null || commands.length == 0) return 0;
        Set<String> obstacleSet = new HashSet<>();
        for(int[] obs : obstacles) obstacleSet.add(obs[0] + "," + obs[1]);
        int maxVal = 0, dir = 0, x = 0, y = 0;
        for(int cmd : commands){
            if(cmd == -1){
                dir = (dir + 1) % 4;
                continue;
            }
            if(cmd == -2){
                dir = (dir - 1 + 4) % 4;
                continue;
            }

            // the turns determines the directions

            if(cmd >= 1 && cmd <= 9){ // 1 step at 1 time
                for(int i = 0; i < cmd; ++i){
                    int xnext = x + DIR[dir][0];
                    int ynext = y + DIR[dir][1];
                    if(obstacleSet.contains(xnext + "," + ynext))
                        break;
                    x += DIR[dir][0];
                    y += DIR[dir][1];
                    maxVal = Math.max(maxVal,x*x + y*y);
                }
            }
        }
        return maxVal;
    }
}
