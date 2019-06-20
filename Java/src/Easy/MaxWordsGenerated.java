package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxWordsGenerated {

    boolean canMake(String word, Map<Character, Integer> freq){
        Map<Character, Integer>counter = new HashMap<>();
        for(Character ch: word.toCharArray()){
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }
        for(Character key: counter.keySet()){
            if(!freq.containsKey(key))
                return false;
            if(freq.get(key) < counter.get(key))
                return false;
        }
        return true;
    }

    List<String> generate(List<String> words, List<Character>letters){
        List<String> ret = new ArrayList<>();
        if(words == null || words.size() == 0 || letters == null || letters.size() <= 0) return ret;
        Map<Character, Integer>freq = new HashMap<>();
        for(Character ch: letters){
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < words.size(); ++i){
            if(!canMake(words.get(i), freq)) continue;

            List<String> result =new ArrayList<String>();
            generate(result, words, i, new HashMap<>(freq));

            if(result.size() > ret.size() && String.join( "", result).length() > String.join( "", ret).length()){
                ret = result;
            }

        }
        return ret;
    }

    void generate(List<String> result, List<String> words, int index, Map<Character, Integer>freq){
        List<String> remains = new ArrayList<>(words);
        String word = remains.get(index);
        result.add(word);
        remains.remove(index);
        for(Character ch: word.toCharArray()) {
            freq.put(ch, freq.get(ch) -1);
        }

        if(remains.size() <= 0){
            return;
        }

        for(int i = 0; i < words.size(); ++i){
            if(!canMake(words.get(i), freq)) continue;
            generate(result, words, i, freq);
        }
    }
}
