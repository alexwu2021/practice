package com.practice.companies.amazon;

import java.util.*;

public class TransactionLogs {

    public List<String> getFraudIds(String[] input, int threshold) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String log : input) {
            String[] logVals = log.split(" ");
            Set<String> set = new HashSet<>(Arrays.asList(logVals[0], logVals[1]));
            for (String userId : set) {
                map.put(userId, map.getOrDefault(userId, 0) + 1);
            }
        }

        for (String userId : map.keySet()) {
            if (map.get(userId) >= threshold)
                res.add(userId);
        }

        Collections.sort(res);

        /*
        Collections.sort(result, new Comparator() {
            public int compare(String s1, String s2) {
                return Integer.valueOf(s1).compareTo(Integer.valueOf(s2));
            }
         });
         */

        return res;
    }


    List<String> findUserIdsWithAtLeastNumberOfTransactions(String[] src, int numberOfTransactions) {
        List<String> ret = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();
        for(String s: src){
            String[] parsed = parsingLog(s);
            if(parsed[0].equals(parsed[1])){
                mp.put(parsed[0], mp.getOrDefault(parsed[0], 0) + 1);
            }else{
                mp.put(parsed[0], mp.getOrDefault(parsed[0], 0) + 1);
                mp.put(parsed[1], mp.getOrDefault(parsed[1], 0) + 1);
            }
        }
        for(String key: mp.keySet()){
            if(mp.get(key) >= numberOfTransactions){
                ret.add(key);
            }
        }
        String[] result = ret.toArray(new String[ret.size()]);
        Arrays.sort(result);
        ret.clear();
        for(String rtemp: result){
            ret.add(rtemp);
        }
        return ret;
    }

    private String[] parsingLog(String s) {
        return s.split(" ");
    }
}
