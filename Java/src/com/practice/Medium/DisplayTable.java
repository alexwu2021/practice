package com.practice.Medium;

import java.util.*;

public class DisplayTable {

    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>>ans = new ArrayList<>();
        Map<Integer, Map<String, Integer>> mp = new TreeMap<>();
        Set<String>uniqueNames = new HashSet<>();
        for(List<String>order: orders){
            int tableId = Integer.valueOf(order.get(1));
            String itemName = order.get(2);
            uniqueNames.add(itemName);
            Map<String, Integer>imp;
            if(mp.containsKey(tableId)){
                imp = mp.get(tableId);
            } else{
                imp = new HashMap<>();
            }
            imp.put(itemName, imp.getOrDefault(itemName, 0) + 1);
            mp.put(tableId, imp);
        }

        List<String>topRow = new ArrayList<>(uniqueNames);
        Collections.sort(topRow);
        topRow.add(0, "Table");
        ans.add(topRow);
        for(Map.Entry<Integer, Map<String, Integer>>entry: mp.entrySet()){
            List<String>dataRow = new ArrayList<>();
            dataRow.add(entry.getKey().toString());
            for (int i = 1; i<topRow.size(); ++i){
                dataRow.add("" + entry.getValue().getOrDefault(topRow.get(i), 0));
            }
            ans.add(dataRow);
        }
        return ans;
    }

}
