package com.practice.Easy;

import java.util.*;

/**  Given a paragraph and a list of banned words, return the most frequent word that is
 * not in the list of banned words.  It is guaranteed there is at least one word that isn't
 * banned, and that the answer is unique.

 Words in the list of banned words are given in lowercase, and free of punctuation.  Words
 in the paragraph are not case sensitive.  The answer is in lowercase.



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


 Note:

 1 <= paragraph.length <= 1000.
 0 <= banned.length <= 100.
 1 <= banned[i].length <= 10.
 The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 There are no hyphens or hyphenated words.
 Words only consist of letters, never apostrophes or other punctuation symbols.
 *
 */

public class MostCommonWords {

    /** passed oj
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> counter = new HashMap<>();
        for (String word : paragraph.toLowerCase().split("\\W+")) //replacing all punctuation symbols with whitespace.
            if (!ban.contains(word)) counter.put(word, counter.getOrDefault(word, 0) + 1);

        return Collections.max(counter.entrySet(), Map.Entry.comparingByValue())
                .getKey(); // this will slow down the performance, but elegant!


        //this is faster
//        int max = 0;
//        String res = "";
//        for (String str : counter.keySet()) {
//            if (counter.get(str) > max) {
//                max = counter.get(str);
//                res = str;
//            }
//        }
//        return res;
    }

    public String mostCommonWord_reference(String p, String[] banned){
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordCounts = new HashMap<>();

        // remove all punctuations and change to lowercase
        String[] words = p.replaceAll("\\W+", " ").toLowerCase().split("\\s+");

        // wordCounts words not in banned list
        for (String w : words) {
            if (!ban.contains(w))
                wordCounts.put(w, wordCounts.getOrDefault(w, 0) + 1);
        }
        return Collections.max(wordCounts.entrySet(), Map.Entry.comparingByValue())
                .getKey();
    }
}
