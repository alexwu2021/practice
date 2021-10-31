package Medium;

import java.util.*;

/**
 *
 */
public class SortFeatureByPopularity {

    class FeatureAndCount{
        public String f;
        public int count;
        public FeatureAndCount(String f, int count){this.f = f; this.count = count;}
    }

    List<Set<String>>resps = new ArrayList<>();

    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer>feature2Index = new HashMap<>();
        Queue<FeatureAndCount>frq = new PriorityQueue<>((a, b) ->{
            if(b.count != a.count){
                return (b.count - a.count);
            }else{
                return feature2Index.getOrDefault(a.f, 0) - feature2Index.getOrDefault(b.f, 0);
            }
        });


        for(String r: responses){
            Set<String>resp = new HashSet<>();
            for(String t: r.split(" ")){
                resp.add(t);
            }
            resps.add(resp);
        }

        int index = 0;
        for(String f : features){
            feature2Index.put(f, index++);
            int count =  getfreq(f);
            frq.offer(new FeatureAndCount(f, count));
        }
        List<String>res = new ArrayList<>();
        while(!frq.isEmpty()){
            FeatureAndCount front = frq.poll();
            res.add(front.f);
        }
        return res.toArray(new String[res.size()]);
    }

    private int getfreq (String s){
        int count = 0;
        for(Set resp: resps){
            if(resp.contains(s)) count++;
        }
        return count;
    }
}