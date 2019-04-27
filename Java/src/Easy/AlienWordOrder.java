package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only
 * if the given words are sorted lexicographicaly in this alien language.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 *
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to
 * lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less
 * than any other character (More info).
 *
 *
 * Note:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are english lowercase letters.
 * Accepted
 */
public class AlienWordOrder {

    private boolean isAlienSortedHelper(String a, String b, Map<Character, Integer>mp){
        int i = 0, j = 0, m = a.length(), n = b.length(), matchCount = 0;
        while(i < m && j < n){
            if(mp.get(b.charAt(j)) < mp.get(a.charAt(i))){
                if( i == 0 ) return false;
                if(mp.get(b.charAt(j - 1)) == mp.get(a.charAt(i - 1))) return false;
            } else if(mp.get(b.charAt(j)) == mp.get(a.charAt(i))){
                matchCount++;
            }
            i++;
            j++;
        }
        // all elements in b have been matched but b is shorter
        // Note: condition matchCount == n is a must
        // if dropped, then even up to the length of n, a is way ahead of b in the dictionary
        // we will return false, which is wrong
        if(matchCount == n && i < m) return false;
        return true;
    }


    public boolean isAlienSorted(String[] words, String order) {
        if(words == null || words.length <= 1 || order == null || order.length() <= 0) return true;

        Map<Character, Integer> mp = new HashMap<>();
        for(int i = 0; i< order.length(); ++i) mp.put(order.charAt(i), i);

        for(int j = 1; j < words.length; ++j) {
            if (!isAlienSortedHelper(words[j - 1], words[j], mp)) return false;
        }
        return true;
    }
}
