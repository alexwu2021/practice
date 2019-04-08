package Easy;

import java.util.*;

public class ReorgLoggs {

    private boolean isNumberic(String s){
        for(Character ch : s.toCharArray()){
            if(ch == ' ') continue;
            if(ch > '9' || ch < '0'){
                return false;
            }
        }
        return true;
    }

    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length <= 0) return null;

        List<String> ret = new ArrayList<>();
        List<String> numberLogs = new ArrayList<>();
        Map<String, Queue<String>> mp = new TreeMap<>();
        for(String log : logs){
            String[] sa = log.split("\\s", 2);
            if(isNumberic(sa[1])){
                numberLogs.add(log);
            } else{
                Queue<String> queue = mp.getOrDefault(sa[1], new PriorityQueue<String>());
                queue.add(sa[0]);
                mp.put(sa[1], queue);
            }
        }
        for(String key: mp.keySet()){
            for(String val: mp.get(key)){
                String result = val + " " + key;
                ret.add(result);
            }
        }
        ret.addAll(numberLogs);
        return ret.toArray(new String[0]);
    }
}
