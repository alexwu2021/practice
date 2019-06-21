package Easy;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() <= 0) return 0;

        int i = s.length() -1;
        while(i >= 0 && s.charAt(i) == ' '){
            i--;
        }
        int j = i;
        while(i >= 0 && s.charAt(i) != ' '){
            i--;
        }
        return j - i ;
    }
}
