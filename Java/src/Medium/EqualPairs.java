package Medium;

import java.util.*;
import java.util.stream.Collectors;

public class EqualPairs {
    public int equalPairs(int[][] grid) {
        Map<String, List<Integer>> col2Indices = new HashMap<>();
        Map<String, List<Integer>> row2Indices = new HashMap<>();

        for(int i =0; i< grid.length; ++i){
            String key = expr(grid[i]);
            row2Indices.put(key,
                    row2Indices.computeIfAbsent(key, x->new ArrayList<>()).add(i);
        }

        for(int j =0; j< grid[0].length; ++j){
            List<Integer>colList = new ArrayList<>();
            for(int r = 0; r< grid.length; ++r){
                colList.add(grid[r][j]);
            }
            String key = expr(colList);
            col2Indices.put(key, col2Indices.computerIfAbsent(key, x->new ArrayList<>()).add(j));
        }





    }

    String expr(int [] arr){
        return Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining("_"));
    }

    String expr(List<Integer> list){
        return list.stream().map(String::valueOf).collect(Collectors.joining("_"));
    }
}
