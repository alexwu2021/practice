package com.practice.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ret = new ArrayList<>();
        if(searchWord == null || searchWord.length() <= 0) return ret;
        Queue<String> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<searchWord.length(); ++i){
            sb.append(searchWord.charAt(i));
            pq.clear();
            populate(pq, products, sb.toString());
            ret.add(toList(pq));
        }
        return ret;
    }

    private List<String> toList(Queue<String>q){
        List<String> ret = new ArrayList<>();
        int count = 0;
        while(!q.isEmpty()){
            ret.add(q.poll());
            if(++count == 3) break;
        }
        return ret;
    }

    private void populate(Queue<String>pq, String[] products, String prefix){
        for(String p : products){
            if(!p.startsWith(prefix)) continue;
            pq.offer(p);
        }
    }
}
