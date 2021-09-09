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
            for(int k = 1; k < strs.length; ++k){
                // others are shorter or having different char
                if(j >= strs[k].length() || ch != strs[k].charAt(j)){
                    return ret;
                }
            }
            ret += "" + ch;
        }
        return ret;
    }


    //---------------good to learn---------------
    //---------------but quite unnecessary---------------

    public String longestCommonPrefix_recurrsion(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) return strs[l];

        int mid = (l + r)/2;
        String lcpLeft =   longestCommonPrefix(strs, l , mid);
        String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
        return commonPrefix(lcpLeft, lcpRight);
    }

    String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; ++i) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

}
