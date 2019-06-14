package Medium;

import java.util.*;

public class LabelPartition {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if(S == null || S.length() <= 0)
            return res;
        Map<Character, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < S.length(); ++i){
            mp.computeIfAbsent(S.charAt(i), x -> new ArrayList<>()).add(i);
        }
        return dfs(S, 0, mp);
    }
    List<Integer> dfs(String S, int start, Map<Character, List<Integer>> mp) {
        List<Integer> res = new ArrayList<>();
        if(start >= S.length())
            return res;

        Character ch = S.charAt(start);
        List<Integer>lst = mp.get(ch);
        if(lst.size() == 1){
            res.add(1);
            res.addAll(dfs(S, start + 1, mp));
            return res;
        }

        Collections.sort(lst);
        int max = lst.get(lst.size()-1);
        int end = max;
        for(int j = start + 1; j < max; ++j){
            List<Integer>tempList = mp.get(S.charAt(j));
            for(Integer tl: tempList)
                if (tl > end)
                    end = tl;
        }

//        for(int j = start + 1; j < max; ++j){
//            OptionalInt temp = mp.get(S.charAt(j)).stream().mapToInt(v->v).max();
//            if(temp.getAsInt() >  end){
//                end = temp.getAsInt();
//            }
//        }

        res.add(end - start + 1);
        res.addAll(dfs(S, end + 1, mp));
        return res;
    }
}
