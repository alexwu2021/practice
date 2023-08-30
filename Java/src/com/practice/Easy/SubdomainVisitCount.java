package com.practice.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {


    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ret = new ArrayList<>();
        if(cpdomains == null || cpdomains.length <= 0)
            return ret;

        Map<String, Integer> counter = new HashMap<>();
        for(String domains: cpdomains){
            getCount(counter, domains);
        }

        for(String key: counter.keySet()){
            ret.add(counter.get(key) + " " + key);
        }
        return ret;
    }

    private void getCount(Map<String, Integer>mp, String domains){
        String[]isa = domains.split("\\s", 2);
        int nm = Integer.valueOf(isa[0]);
        mp.put(isa[1], nm);


        String[] sa = isa[1].split("\\.");
        for(int i = sa.length - 1; i>= 0; --i) {
            String temp = "";
            for(int j = i; j <= sa.length - 1; ++j){
                temp += sa[j];
                if(j <= sa.length-2)
                    temp += ".";
            }
            mp.put(temp, mp.getOrDefault(temp, 0) + nm);
        }
    }
}
