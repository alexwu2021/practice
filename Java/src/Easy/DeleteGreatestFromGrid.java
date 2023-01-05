package Easy;
//2500. Delete Greatest Value in Each Row
//Easy
//199
//13
//You are given an m x n matrix grid consisting of positive integers.
//
//Perform the following operation until grid becomes empty:
//
//Delete the element with the greatest value from each row. If multiple such elements exist, delete any of them.
//Add the maximum of deleted elements to the answer.
//Note that the number of columns decreases by one after each operation.
//
//Return the answer after performing the operations described above.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DeleteGreatestFromGrid {

    public int deleteGreatestValue(int[][] grid) {
        List<PriorityQueue<Integer>>pqs = new ArrayList<>();
        for(int i=0; i<grid.length; ++i) {
            Arrays.sort(grid[i]);
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            for (int j= grid[i].length-1; j>=0; --j)
                pq.add(grid[i][j]);
            pqs.add(pq);
        }

        int ans = 0;
        PriorityQueue<Integer> res = new PriorityQueue<>((a, b) -> (b - a));
        while(!pqs.get(0).isEmpty()){
            for(PriorityQueue<Integer>pq : pqs) {
                res.add(pq.poll());
            }
            ans += res.poll();
            res.clear();
        }
        return ans;
    }
}
