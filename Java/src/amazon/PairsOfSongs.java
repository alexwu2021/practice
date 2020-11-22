package amazon;

import java.util.*;

public class PairsOfSongs {

    public int getNumberOfPairs(int[] times){
        Map<Integer, List<Integer>> valToIndices = new HashMap<>();
        for(int i = 0; i < times.length; ++i){
            valToIndices.computeIfAbsent(times[i], x ->new ArrayList<Integer>()).add(i);
        }
        Set<int[]> pairs = new HashSet<>();
        Integer[] arr = valToIndices.keySet().toArray(new Integer[valToIndices.keySet().size()]);
        for(int j=0; j<arr.length-1; ++j) {
            for(int k=j+1; k<arr.length; ++k){
                if((arr[j] + arr[k]) % 60 == 0){
                    addToSet(pairs, valToIndices.get(arr[j]), valToIndices.get(arr[k]));
                }
            }
        }
        return pairs.size();
    }

    private void addToSet(Set<int[]> pairs, List<Integer> list1, List<Integer> list2) {
        for(int j=0; j<list1.size(); ++j) {
            for(int k=0; k<list2.size(); ++k){
                pairs.add(new int[]{list1.get(j), list2.get(k)});
            }
        }
    }
}
