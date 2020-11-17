package amazon;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/*
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.



Example:

Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.
 */
public class MostFrequentWord {


    /**
     * @param srcString
     * @param bannedWords
     * @return
     * @throws Exception
     */
    public String mostFrequentWord(String srcString, String[] bannedWords) throws Exception {

        if(srcString == null || srcString.length() <= 0)
            return "";

        srcString = srcString.replace(",", "").replace(".", "");
        Set<String> banned = new HashSet<>();
        for(String w: bannedWords)
            banned.add(w);

        Map<String, Integer> wordFreq = new HashMap<>();
        Map<Integer, List<String>> freqToWord = new HashMap<>();
        int mx = Integer.MIN_VALUE;

        String[] src = srcString.split(" ");
        for(String t: src){
            String s = t.toLowerCase();
            int temp = wordFreq.getOrDefault(s, 0) + 1;
            wordFreq.put(s, temp);
            if(temp > mx)
                mx = temp;
        }
        for (String key : wordFreq.keySet()) {
            int val = wordFreq.get(key);

            List<String>list = freqToWord.get(val);
            if(list == null) {
                list = new ArrayList<>();
            }
            list.add(key);
            freqToWord.put(val, list);
        }
        for(int i = mx; i>= 1; --i){
            List<String> found = freqToWord.get(i);
            if(found != null){
                for(String f : found){
                   if(!banned.contains(f))
                       return f;
                }
            }
        }
        throw new Exception("unexpected error found for we are not supposed to come here!");
    }

}
