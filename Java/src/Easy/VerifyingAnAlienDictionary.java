package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
 *
 *
 *

 */
public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer>mp = new HashMap<>();
        for(int k =0; k < order.length(); ++k) mp.put(order.charAt(k), k );
        int n = words.length;
        for(int i =0; i<n-1; i++){
            if(!inOrder(words[i], words[i+1], mp))
                return false;
        }
        return true;
    }

    private boolean inOrder(String s, String t, Map<Character, Integer> mp){
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while(i <m && i < n){
            if(mp.get(s.charAt(i)) > mp.get(t.charAt(j))){
                return false;
            } else if(mp.get(s.charAt(i)) < mp.get(t.charAt(j))){
                return true;
            } else{
                i++; j++;
            }
        }
        if(i == m && i < n) return true;
        if(i < m && i == n) return false;
        return true;
    }
}
