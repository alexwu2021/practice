package Easy;

public class Palindrom2 {

    /** passed oj
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j && s.charAt(i) == s.charAt(j)){
            i++; j--;
        }
        if(j <= i) return true;

        int i1 = i + 1, j1 = j;
        while(i1 < j1 && s.charAt(i1) == s.charAt(j1)){
            i1++; j1--;
        }
        if(j1 <= i1) return true;


        int i2 = i, j2 = j-1;
        while(i2 < j2 && s.charAt(i2) == s.charAt(j2)){
            i2++; j2--;
        }
        if(j2 <= i2) return true;

        return false;
    }
}
