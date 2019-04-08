package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueWordsInTwoStrings {


    /** my own implementation, passed OJ
     * @param A
     * @param B
     * @return
     */
    public String[] uncommonFromSentences_mine(String A, String B) {

        List<String> ret = new ArrayList<>();
        Map<String, Integer>mapa = new HashMap<>();
        Map<String, Integer>mapb = new HashMap<>();

        for(String stra: A.split("\\s"))
            mapa.put(stra, mapa.getOrDefault(stra, 0) + 1);

        for(String strb: B.split("\\s"))
            mapb.put(strb, mapb.getOrDefault(strb, 0) + 1);


        for(String keya: mapa.keySet()){
            if(mapa.get(keya) == 1 && !mapb.containsKey(keya)){
                ret.add(keya);
            }
        }

        for(String keyb: mapb.keySet()){
            if(mapb.get(keyb) == 1 && !mapa.containsKey(keyb)){
                ret.add(keyb);
            }
        }

        return ret.toArray(new String[0]);

    }

    /** this one is really good
     * @param A
     * @param B
     * @return
     */
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap<>();
        for (String w : (A + " " + B).split(" "))
            count.put(w, count.getOrDefault(w, 0) + 1);
        List<String> res = new ArrayList<>();
        for (String w : count.keySet())
            if (count.get(w) == 1)
                res.add(w);
        return res.toArray(new String[0]); //this is a trick for converting list to array
    }
}


