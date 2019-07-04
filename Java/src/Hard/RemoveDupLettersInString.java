package Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Example 1:
 *
 * Input: "bcabc"
 * Output: "abc"
 * Example 2:
 *
 * Input: "cbacdcbc"
 * Output: "acdb"
 *
 * explanation for the last example:
 * initially we have last indices: c @ 7, b @ 6, a @ 2, d @ 4
 * among them, a whose last index is 2 will be picked up first, because the considered range now is [0, 2]
 * then drop a from consideration, find the least last index which is 4, and in the range [3, 4] where 3 is derived by incrementing 2
 * we have two two characters for selection: {'c', 'd'}, by the lexicographical rule, we pick 'c'
 *
 * ...
 *
 *
 *
 */
public class RemoveDupLettersInString {

    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) return s;

        Map<Character, Integer> lastPosMap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            lastPosMap.put(s.charAt(i), i);
        }

        char[] result = new char[lastPosMap.size()];
        int begin = 0, end = findMinLastPos(lastPosMap);

        for (int j = 0; j < result.length; ++j) {
            char minChar = 'z' + 1;
            for (int k = begin; k <= end; ++k) {
                if (lastPosMap.containsKey(s.charAt(k)) && s.charAt(k) < minChar) {
                    minChar = s.charAt(k);
                    begin = k + 1;
                }
            }

            result[j] = minChar;
            if (j == result.length - 1) break;

            lastPosMap.remove(minChar);
            if (s.charAt(end) == minChar) {
                end = findMinLastPos(lastPosMap);
            }
        }

        return new String(result);
    }

    private int findMinLastPos(Map<Character, Integer> lastPosMap) {
        if (lastPosMap == null || lastPosMap.isEmpty()) return -1;
        int minLastPos = Integer.MAX_VALUE;
        for (int lastPos : lastPosMap.values()) {
            minLastPos = Math.min(minLastPos, lastPos);
        }
        return minLastPos;
    }

}
