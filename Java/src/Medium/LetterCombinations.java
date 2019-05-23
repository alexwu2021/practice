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
    private Map<Integer, List<Character>> _mp;
    private List<String> _retList;

    public List<String> letterCombinations(String digits) {
        this._retList = new LinkedList<>();
        if(digits == null || digits.length() <= 0) return this._retList;
        digits = digits.trim();
        for(Character ch: digits.toCharArray()) if(ch > '9' || ch < '2') return this._retList;

        _mp = new HashMap<>();
        _mp.put(2, Arrays.asList(new Character[]{'a', 'b', 'c'}));
        _mp.put(3, Arrays.asList(new Character[]{'d', 'e', 'f'}));
        _mp.put(4, Arrays.asList(new Character[]{'g', 'h', 'i'}));
        _mp.put(5, Arrays.asList(new Character[]{'j', 'k', 'l'}));
        _mp.put(6, Arrays.asList(new Character[]{'m', 'n', 'o'}));
        _mp.put(7, Arrays.asList(new Character[]{'p', 'q', 'r', 's'}));
        _mp.put(8, Arrays.asList(new Character[]{'t', 'u', 'v'}));
        _mp.put(9, Arrays.asList(new Character[]{'w', 'x', 'y', 'z'}));

        List<String> ret = new ArrayList<>();
        dfs(digits, 0, ret);
        return this._retList;
    }


    void dfs(String digits, int index, List<String> lst) {
       if(index == digits.length() - 1){
           if(lst.isEmpty()){
               for(Character ch : _mp.get(digits.charAt(index) - '0')){
                   this._retList.add("" + ch);
               }
               return;
           }
           for(String s: lst){
               for(Character ch : _mp.get(digits.charAt(index) - '0')){
                   this._retList.add(s + ch);
               }
           }
           return;
       }

       List<Character> listOfChars = _mp.get(digits.charAt(index) - '0');
       for(Character ch : listOfChars){
           List<String> tempList = new ArrayList<>();
           if(lst.isEmpty()){
               tempList.add("" + ch);
           }else{
               for(String str: lst){
                   tempList.add(str + ch);
               }
           }
           dfs(digits, index + 1, tempList);
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