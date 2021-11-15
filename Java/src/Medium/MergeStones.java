package Medium;

import java.util.ArrayList;
import java.util.List;

public class MergeStones {
    public int mergeStones(int[] stones, int k) {
        List<Integer> lst = new ArrayList<>(), newList = new ArrayList<>();
        int totalCost = 0;
        for(int stone: stones) lst.add(stone);
        do{
            int start = -1, mx = Integer.MAX_VALUE;
            for(int i=0; i<=lst.size() -k; ++i){
                int temp = 0;
                for(int j= i; j <i+ k; ++j){
                    temp += lst.get(j);
                }
                if(temp < mx){
                    mx = temp;
                    start = i;
                }
            }
            int r;
            for(r = 0; r<start; ++r)
                newList.add(lst.get(r));
            int tempSum = 0;
            for(r = start; r<start+k; ++r)
                tempSum += lst.get(r);
            System.out.print("merged with cost of " + tempSum);
            newList.add(tempSum);
            totalCost += tempSum;
            for(r = start+k; r<lst.size(); ++r)
                newList.add(lst.get(r));
            lst.clear();
            lst.addAll(newList);
            newList.clear();
        }while(lst.size() >= k );

        if(lst.size() >1) return -1;
        return totalCost;
    }
}
