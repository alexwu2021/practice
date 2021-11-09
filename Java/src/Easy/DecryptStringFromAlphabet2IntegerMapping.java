package Easy;

/**
 * Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:
 *
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
 * Return the string formed after mapping.
 *
 * It's guaranteed that a unique mapping will always exist.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "10#11#12"
 * Output: "jkab"
 * Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * Example 2:
 *
 * Input: s = "1326#"
 * Output: "acz"
 * Example 3:
 *
 * Input: s = "25#"
 * Output: "y"
 * Example 4:
 *
 * Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * Output: "abcdefghijklmnopqrstuvwxyz"
 */
public class DecryptStringFromAlphabet2IntegerMapping {
    public String freqAlphabets(String s) {
        int index = s.indexOf("#");
        if(index < 0){
            return convert(s);
        }else {
            String res = convert(s.substring(0, index-2));
            Integer val = Integer.valueOf(s.substring(index-2, index)) - 10;
            String str = (char)(val + 'j') + "";
            String other = "";
            if(index + 1 < s.length()) other = freqAlphabets(s.substring(index+1)) ;
            return res + str + other;
        }
    }

    String convert(String s){
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()){
            char newChar = (char)((Integer.valueOf(ch) - 49) + 'a');
            sb.append("" + newChar);
        }
        return sb.toString();
    }
}
