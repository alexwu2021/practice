package Medium;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 *
 *
 * 25 / 25 test cases passed.
 * Status: Accepted
 * Runtime: 2 ms
 * Memory Usage: 35.2 MB
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();

        if(digits == null || digits.length() <= 0) return ret;

        digits = digits.trim();
        for(Character ch: digits.toCharArray()) if(ch > '9' || ch < '2') return ret;

        Map<Integer, List<Character>> mp = new HashMap<>();
        mp.put(2, Arrays.asList(new Character[]{'a', 'b', 'c'}));
        mp.put(3, Arrays.asList(new Character[]{'d', 'e', 'f'}));
        mp.put(4, Arrays.asList(new Character[]{'g', 'h', 'i'}));
        mp.put(5, Arrays.asList(new Character[]{'j', 'k', 'l'}));
        mp.put(6, Arrays.asList(new Character[]{'m', 'n', 'o'}));
        mp.put(7, Arrays.asList(new Character[]{'p', 'q', 'r', 's'}));
        mp.put(8, Arrays.asList(new Character[]{'t', 'u', 'v'}));
        mp.put(9, Arrays.asList(new Character[]{'w', 'x', 'y', 'z'}));

        dfs(digits, 0, ret, "", mp);
        return ret;
    }


    void dfs(String digits, int index, List<String>ret, String prefix, Map<Integer, List<Character>> mp) {
        if (index == digits.length() - 1) {
            for (Character ch : mp.get(digits.charAt(index) - '0'))
                ret.add(prefix + ch);
            return;
        }

        List<Character> listOfChars = mp.get(digits.charAt(index) - '0');
        for (Character ch : listOfChars) {
            dfs(digits, index + 1, ret, prefix + ch, mp);
        }
    }
}

class Solution_lei31 {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<String>();
        combination("", digits, 0, ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }
}