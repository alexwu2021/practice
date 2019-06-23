package Easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String ret = "";
        if(strs == null || strs.length <= 0) return ret;

        String first = strs[0];
        for(int j = 0; j < first.length(); ++j){
            Character ch = first.charAt(j);
            for(int k= 1; k < strs.length; ++k){
                if(j >= strs[k].length() || ch != strs[k].charAt(j)){
                    return ret;
                }
            }
            ret += "" + ch;
        }
        return ret;
    }
}
