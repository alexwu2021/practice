package Medium;

import java.util.*;

/**
 *
 */
public class SortFeatureByPopularity {





    /** most practical, about 50+ ms
     * @param f
     * @param r
     * @return
     */
    public String[] sortFeatures(String[] f, String[] r) {
        HashMap<String, Integer>mp = new HashMap<>();
        for(String res : r) {
            Set<String> st = new HashSet<>();
            Collections.addAll(st, res.split(" "));
            for(String w : st) mp.put(w, mp.getOrDefault(w, 0) + 1);
        }
        Arrays.sort(f, (a,b)->(mp.getOrDefault(b, 0)- mp.getOrDefault(a, 0)));
        return(f);
    }


    // ----- this is my original version, and should not be used -------

    class FeatureAndCount{
        public String f;
        public int count;
        public FeatureAndCount(String f, int count){this.f = f; this.count = count;}
    }

    /** 203 ms
     * @param features
     * @param responses
     * @return
     */
    public String[] sortFeatures_pq(String[] features, String[] responses) {
        Map<String, Integer>feature2Index = new HashMap<>();
        Queue<FeatureAndCount>frq = new PriorityQueue<>((a, b) ->{
            if(b.count != a.count) return (b.count - a.count);
            else return feature2Index.getOrDefault(a.f, 0) - feature2Index.getOrDefault(b.f, 0);
        });

        List<Set<String>>resps = new ArrayList<>();
        for(String r: responses){
            Set<String>resp = new HashSet<>();
            Collections.addAll(resp, r.split(" "));
            resps.add(resp);
        }

        int index = 0;
        for(String f : features){
            feature2Index.put(f, index++);
            int count = 0;
            for(Set resp: resps) if(resp.contains(f)) count++;
            frq.offer(new FeatureAndCount(f, count));
        }
        String[] ans = new String[frq.size()];

        int j = 0;
        while(!frq.isEmpty()){
            ans[j++] = frq.poll().f;
        }
        return ans;
    }
}