package com.practice.Easy;

import java.util.HashMap;
import java.util.Map;

class MapSum {
    Map<String, Integer> mp;
    public MapSum() {
        mp = new HashMap<>();
    }

    public void insert(String key, int val) {
        mp.put(key, val);
    }

    public int sum(String prefix) {
        if(prefix == null && mp.containsKey(prefix))
            return mp.get(prefix);

        int ret = 0;
        for(String key: mp.keySet()){
            if(key != null && key.startsWith(prefix))
                ret += mp.get(key);
        }
        return ret;
    }
}

