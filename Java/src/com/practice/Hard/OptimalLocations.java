package com.practice.Hard;

public class OptimalLocations {

    public int optimalLocations(int[]centers, int distance){
        int left = findLeft(centers, distance), right = findRight(centers, distance);
        return right - left + 1;

    }

    private int findLeft(int[] centers, int distance) {
        int leftMost = centers[0];
        int i = leftMost - distance;
        while(distanceSum(centers, i) > distance){
            i++;
        }
        return i;
    }

    int distanceSum(int[] centers, int testPoint){
        int sm = 0;
        for(int c: centers){
            sm += Math.abs(c - testPoint) * 2;
        }
        return sm;
    }

    private int findRight(int[] centers, int distance) {
        int rightMost = centers[centers.length -1];
        int i = rightMost + distance;
        while(distanceSum(centers, i) > distance){
            i--;
        }
        return i;
    }
}
